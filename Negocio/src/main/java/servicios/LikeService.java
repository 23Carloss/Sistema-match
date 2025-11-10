package servicios;

import DTOs.LikeDTO;
import DTOs.MatchDTO;
import Mappers.LikeMapper;
import entidades.Likes;
import exception.NegocioException;
import exception.PersistenciaException;
import interfaces.ILikeDAO;
import java.util.List;

/**
 * Servicio de Like que implementa la lógica de negocio para likes.
 *
 * @author brand
 */
public class LikeService implements ILikeService {

    private final ILikeDAO likeDAO;
    private final LikeMapper mapper;
    private final IMatchService matchService;

    public LikeService(ILikeDAO likeDAO, IMatchService matchService) {
        this.likeDAO = likeDAO;
        this.mapper = new LikeMapper();
        this.matchService = matchService;
    }

    @Override
    public void crear(LikeDTO like) throws NegocioException {
        try {
            // Validaciones usuales...
            if (like == null) {
                throw new NegocioException("El like no puede ser nulo.");
            }
            if (like.getEstudianteOrigen() == null || like.getEstudianteDestino() == null) {
                throw new NegocioException("Debe haber estudiante origen y destino.");
            }
            if (like.getEstudianteOrigen().getId().equals(like.getEstudianteDestino().getId())) {
                throw new NegocioException("Un estudiante no puede darse like a sí mismo.");
            }
//            if (like.getFechaHora() == null || like.getFechaHora().isAfter(java.time.LocalDateTime.now())) {
//                throw new NegocioException("La fecha del like no puede ser futura.");
//            }

            // No duplicar likes
            List<Likes> existentes = likeDAO.listar(100);
            boolean yaExiste = existentes.stream()
                    .anyMatch(l -> l.getEstudianteOrigen().getIdEstudiante().equals(like.getEstudianteOrigen().getId())
                    && l.getEstudianteDestino().getIdEstudiante().equals(like.getEstudianteDestino().getId()));
            if (yaExiste) {
                throw new NegocioException("Ya existe un like entre estos estudiantes.");
            }

            // Persistir el nuevo like
            likeDAO.agregar(mapper.convertirAEntity(like));

            // ***RECÍPROCO: buscar el like inverso***
            boolean reciproco = existentes.stream()
                    .anyMatch(l -> l.getEstudianteOrigen().getIdEstudiante().equals(like.getEstudianteDestino().getId())
                    && l.getEstudianteDestino().getIdEstudiante().equals(like.getEstudianteOrigen().getId()));

            if (reciproco) {
                // Validaciones opcionales de que no exista el MATCH previamente
//                // Crear el match
//                MatchDTO nuevoMatch = new MatchDTO();
//                nuevoMatch.setEstudiante1(like.getEstudianteOrigen());
//                nuevoMatch.setEstudiante2(like.getEstudianteDestino());
//                nuevoMatch.setFechaHoraMatch(java.time.LocalDateTime.now());

//                matchService.crear(nuevoMatch); // Llama al servicio y crea el match
            }
        } catch (PersistenciaException e) {
            throw new NegocioException("Error en persistencia: " + e.getMessage(), e);
        }
    }

    @Override

    public LikeDTO buscarPorId(Long id) throws NegocioException {
        try {
            if (id == null || id <= 0) {
                throw new NegocioException("ID no válido.");
            }
            Likes like = likeDAO.obtenerPorId(id);
            if (like == null) {
                throw new NegocioException("No se encontró el Like con ID " + id);
            }
            return mapper.convertirADto(like);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error en persistencia: " + e.getMessage(), e);
        }
    }

    @Override
    public List<LikeDTO> listar(int limite) throws NegocioException {
//        try {
            if (limite <= 0) {
                throw new NegocioException("El límite debe ser mayor que cero.");
            }
            if (limite > 100) {
                throw new NegocioException("El límite máximo permitido es 100.");
            }
//            return mapper.convertirListaADto(likeDAO.listar(limite));
return null;
//        } catch (PersistenciaException e) {
//            throw new NegocioException("Error en persistencia: " + e.getMessage(), e);
//        }
    }

    @Override
    public void actualizar(LikeDTO like) throws NegocioException {
        try {
            if (like == null) {
                throw new NegocioException("El like no puede ser nulo.");
            }
            if (like.getId() == null) {
                throw new NegocioException("El ID es obligatorio para actualizar.");
            }
            Likes existente = likeDAO.obtenerPorId(like.getId());
            if (existente == null) {
                throw new NegocioException("No se encontró el Like con ID " + like.getId());
            }
            likeDAO.actualizar(mapper.convertirAEntity(like));
        } catch (PersistenciaException e) {
            throw new NegocioException("Error en persistencia: " + e.getMessage(), e);
        }
    }

    @Override
    public void eliminar(Long id) throws NegocioException {
        try {
            if (id == null || id <= 0) {
                throw new NegocioException("ID no válido para eliminar.");
            }
            likeDAO.eliminar(id);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error en persistencia: " + e.getMessage(), e);
        }
    }
}
