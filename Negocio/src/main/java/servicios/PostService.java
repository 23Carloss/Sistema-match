package servicios;

import DTOs.PostDTO;
import DTOs.EstudianteDTO;
import Mappers.PostMapper;
import entidades.Post;
import exception.NegocioException;
import exception.PersistenciaException;
import interfaces.IPostDAO;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Servicio enriquecido para Post con reglas y validaciones
 */
public class PostService implements IPostService {

    private final IPostDAO postDAO;
    private final PostMapper mapper;
    private static final int LIMITE_CARACTERES = 500;
    private static final Set<String> PALABRAS_PROHIBIDAS = new HashSet<>(Arrays.asList(
            "spam", "tonto", "ofensivo", "inapropiado", "hack", "<script>", "<img", "javascript:"
    ));

    public PostService(IPostDAO postDAO) {
        this.postDAO = postDAO;
        this.mapper = new PostMapper();
    }

    private boolean contienePalabrasProhibidas(String mensaje) {
        String msj = mensaje.toLowerCase();
        return PALABRAS_PROHIBIDAS.stream().anyMatch(msj::contains);
    }

    private String sanitizarMensaje(String mensaje) {
        // elimina etiquetas html peligrosas
        return mensaje.replaceAll("<.*?>", "") // elimina cualquier etiqueta
                .replaceAll("javascript:.*", "") // elimina intentos de script
                .replaceAll("&", "&amp;") // escapa &
                .replaceAll("\"", "&quot;");    // escapa "
    }

    @Override
    public void agregarPost(PostDTO post) throws NegocioException {
        try {
            if (post == null) {
                throw new NegocioException("El post no puede ser nulo.");
            }
            String mensaje = post.getMensaje();
            if (mensaje == null || mensaje.replaceAll("\\s+", "").isEmpty()) {
                throw new NegocioException("El mensaje no puede estar vacío o sólo contener espacios.");
            }
            if (mensaje.length() > LIMITE_CARACTERES) {
                throw new NegocioException("El mensaje no puede superar los " + LIMITE_CARACTERES + " caracteres.");
            }
            if (contienePalabrasProhibidas(mensaje)) {
                throw new NegocioException("El mensaje contiene palabras prohibidas o lenguaje ofensivo.");
            }
            // No permitir solo emojis: si el mensaje es solo Unicode emoji o espacios.
            if (mensaje.replaceAll("[\\p{So}\\s]+", "").isEmpty()) {
                throw new NegocioException("El mensaje no puede ser solo emojis.");
            }

            if (post.getEstudiante() == null || post.getEstudiante().getId() == null) {
                throw new NegocioException("El post debe pertenecer a un estudiante válido.");
            }

            // Antispam en corto intervalo: último post igual en 30 seg
            List<PostDTO> ultimosPosts = obtenerPostPorEstudiante(post.getEstudiante());
            if (!ultimosPosts.isEmpty()) {
                PostDTO ultimo = ultimosPosts.get(ultimosPosts.size() - 1);
                if (ultimo.getMensaje().trim().equals(mensaje.trim())
                        && ultimo.getCreadoEn().plusSeconds(30).isAfter(Instant.now())) {
                    throw new NegocioException("Ya publicaste un post idéntico recientemente.");
                }
            }

            // Validar estudiante activo (si tienes campo "activo" en DTO)
            // if (!post.getEstudiante().isActivo()) throw new NegocioException("El estudiante no está activo.");
            if (post.getCreadoEn() != null && post.getCreadoEn().isAfter(Instant.now())) {
                throw new NegocioException("No se puede publicar un post con fecha futura.");
            }

            if (post.getNumeroReacciones() < 0) {
                throw new NegocioException("El número de reacciones no puede ser negativo.");
            }

            // Sanitización para evitar XSS/HTML/script
            post.setMensaje(sanitizarMensaje(mensaje));
            post.setCreadoEn(Instant.now());
            post.setNumeroReacciones(0);

            postDAO.agregarPost(mapper.convertirAEntity(post));
        } catch (PersistenciaException e) {
            throw new NegocioException("Error en persistencia: " + e.getMessage(), e);
        }
    }

    @Override
    public PostDTO actualizarPost(PostDTO post) throws NegocioException {
        try {
            if (post == null) {
                throw new NegocioException("El post no puede ser nulo.");
            }
            if (post.getId() == null) {
                throw new NegocioException("El ID del post es obligatorio para actualizar.");
            }
            // Solo permite actualizar si el mensaje cumple lo mismo que al crear
            if (post.getMensaje() == null || post.getMensaje().replaceAll("\\s+", "").isEmpty()) {
                throw new NegocioException("El mensaje no puede estar vacío.");
            }
            if (post.getMensaje().length() > LIMITE_CARACTERES) {
                throw new NegocioException("El mensaje no puede superar los " + LIMITE_CARACTERES + " caracteres.");
            }
            if (contienePalabrasProhibidas(post.getMensaje())) {
                throw new NegocioException("El mensaje contiene palabras prohibidas.");
            }
            if (post.getNumeroReacciones() < 0) {
                throw new NegocioException("El número de reacciones no puede ser negativo.");
            }
            // No permitir cambiar el estudiante dueño del post
            // Puedes verificar aquí si el estudiante del DTO coincide con el de la BD
            PostDTO existente = obtenerPostFeed().stream()
                    .filter(p -> p.getId().equals(post.getId())).findFirst().orElse(null);
            if (existente != null && !existente.getEstudiante().getId().equals(post.getEstudiante().getId())) {
                throw new NegocioException("No se puede cambiar el dueño del post.");
            }

            post.setMensaje(sanitizarMensaje(post.getMensaje()));

            Post actualizado = postDAO.actualizarPost(mapper.convertirAEntity(post));
            return mapper.convertirADto(actualizado);

        } catch (PersistenciaException e) {
            throw new NegocioException("Error en persistencia: " + e.getMessage(), e);
        }
    }

    @Override
    public void eliminarPost(long id) throws NegocioException {
        try {
            if (id <= 0) {
                throw new NegocioException("El ID proporcionado no es válido para eliminar.");
            }
            postDAO.eliminarPost(id);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error en persistencia: " + e.getMessage(), e);
        }
    }

    @Override
    public List<PostDTO> obtenerPostPorEstudiante(EstudianteDTO estudiante) throws NegocioException {
        try {
            if (estudiante == null || estudiante.getId() == null) {
                throw new NegocioException("Se requiere un estudiante válido para ver sus posts.");
            }
            List<PostDTO> posts = mapper.convertirLista(postDAO.obtenerPostPorEstudiante(estudiante.getId()));
            return posts;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error en persistencia: " + e.getMessage(), e);
        }
    }

    @Override
    public List<PostDTO> obtenerPostFeed() throws NegocioException {
        try {
            List<PostDTO> posts = mapper.convertirLista(postDAO.obtenerPostFeed());
            return posts;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error en persistencia: " + e.getMessage(), e);
        }
    }
}
