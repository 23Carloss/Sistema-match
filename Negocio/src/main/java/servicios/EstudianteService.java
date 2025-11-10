package servicios;

import DTOs.EstudianteDTO;
import Mappers.EstudianteMapper;
import entidades.Estudiante;
import entidades.Hobby;
import exception.NegocioException;
import exception.PersistenciaException;
import interfaces.IEstudianteDAO;
import java.util.List;
import java.util.regex.Pattern;

/**
 * EstudianteService Clase de servicios de Estudiante que implementa la interfaz
 * IEstudianteService y contiene la lógica de negocio. Los mensajes de UI NO van
 * aquí.
 *
 * @author brand
 */
public class EstudianteService implements IEstudianteService {

    private final IEstudianteDAO estudianteDAO;
    private final EstudianteMapper mapper;
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"
    );

    public EstudianteService(IEstudianteDAO estudianteDAO) {
        this.estudianteDAO = estudianteDAO;
        this.mapper = new EstudianteMapper();
    }

    @Override
    public void crear(EstudianteDTO estudiante) throws NegocioException {
        try {
            if (estudiante == null) {
                throw new NegocioException("El estudiante no puede ser nulo.");
            }
            if (estudiante.getNombre() == null || estudiante.getNombre().trim().isEmpty()) {
                throw new NegocioException("El nombre es obligatorio.");
            }
            if (estudiante.getApellidoPaterno() == null || estudiante.getApellidoPaterno().trim().isEmpty()) {
                throw new NegocioException("El apellido paterno es obligatorio.");
            }
            if (estudiante.getCorreo() == null || estudiante.getCorreo().trim().isEmpty()) {
                throw new NegocioException("El correo es obligatorio.");
            }
            if (!EMAIL_PATTERN.matcher(estudiante.getCorreo()).matches()) {
                throw new NegocioException("El correo no tiene un formato válido.");
            }
            if (estudiante.getContrasenia() == null || estudiante.getContrasenia().length() < 8) {
                throw new NegocioException("La contraseña debe tener al menos 8 caracteres.");
            }
            if (estudiante.getCarrera() == null || estudiante.getCarrera().trim().isEmpty()) {
                throw new NegocioException("La carrera es obligatoria.");
            }
            if (estudiante.getHobbies() == null || estudiante.getHobbies().isEmpty()) {
                throw new NegocioException("Debe seleccionar al menos un hobby.");
            }
            for (String hobby : estudiante.getHobbies()) {
                try {
                    Hobby.valueOf(hobby); // Valida que el hobby exista en el enum
                } catch (IllegalArgumentException ex) {
                    throw new NegocioException("El hobby '" + hobby + "' no es válido.");
                }
            }

            // Unicidad de correo y nombre completo
            List<Estudiante> existentesCorreo = estudianteDAO.buscarPorNombre(estudiante.getNombre());
            boolean correoDuplicado = existentesCorreo.stream()
                    .anyMatch(e -> e.getCorreo().equalsIgnoreCase(estudiante.getCorreo()));
            if (correoDuplicado) {
                throw new NegocioException("Ya existe un estudiante con el mismo correo.");
            }
            // Unicidad nombre completo
            boolean nombreCompletoDuplicado = existentesCorreo.stream()
                    .anyMatch(e -> e.getApellidoPaterno().equalsIgnoreCase(estudiante.getApellidoPaterno())
                    && e.getApellidoMaterno().equalsIgnoreCase(estudiante.getApellidoMaterno()));
            if (nombreCompletoDuplicado) {
                throw new NegocioException("Ya existe un estudiante con el mismo nombre completo.");
            }

            // Contraseña insegura: no permitir "12345678", "contraseña", etc.
            if (estudiante.getContrasenia().matches("(?i)(12345678|password|contraseña)")) {
                throw new NegocioException("La contraseña elegida es demasiado insegura.");
            }

            estudianteDAO.agregar(mapper.ConvertirAEntity(estudiante));
        } catch (PersistenciaException e) {
            throw new NegocioException("Error en persistencia: " + e.getMessage(), e);
        }
    }

    @Override
    public EstudianteDTO buscarPorId(Long id) throws NegocioException {
        try {
            if (id == null || id <= 0) {
                throw new NegocioException("El ID proporcionado no es válido.");
            }

            Estudiante estudiante = estudianteDAO.obtenerPorId(id);
            if (estudiante == null) {
                throw new NegocioException("No se encontró el estudiante con ID " + id);
            }

            return mapper.ConvertirADto(estudiante);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error en persistencia: " + e.getMessage(), e);
        }
    }

    @Override
    public List<EstudianteDTO> listar(int limite) throws NegocioException {
        try {
            if (limite <= 0) {
                throw new NegocioException("El límite debe ser mayor que cero.");
            }
            if (limite > 100) {
                throw new NegocioException("El límite máximo permitido es 100.");
            }
            return mapper.ConvertirListaADto(estudianteDAO.listar(limite));
        } catch (PersistenciaException e) {
            throw new NegocioException("Error en persistencia: " + e.getMessage(), e);
        }
    }

    @Override
    public void actualizar(EstudianteDTO estudiante) throws NegocioException {
        try {
            if (estudiante == null) {
                throw new NegocioException("El estudiante no puede ser nulo.");
            }
            if (estudiante.getId() == null) {
                throw new NegocioException("El ID es obligatorio para actualizar.");
            }

            Estudiante existente = estudianteDAO.obtenerPorId(estudiante.getId());
            if (existente == null) {
                throw new NegocioException("No se encontró el estudiante con ID " + estudiante.getId());
            }

            if (estudiante.getCorreo() != null
                    && !EMAIL_PATTERN.matcher(estudiante.getCorreo()).matches()) {
                throw new NegocioException("El correo no tiene un formato válido.");
            }

            boolean hayCambios = !equalsOrNull(existente.getNombre(), estudiante.getNombre())
                    || !equalsOrNull(existente.getApellidoPaterno(), estudiante.getApellidoPaterno())
                    || !equalsOrNull(existente.getApellidoMaterno(), estudiante.getApellidoMaterno())
                    || !equalsOrNull(existente.getCorreo(), estudiante.getCorreo())
                    || !equalsOrNull(existente.getContrasenia(), estudiante.getContrasenia())
                    || !equalsOrNull(existente.getCarrera(), estudiante.getCarrera())
                    || !listEquals(existente.getHobby(), estudiante.getHobbies());

            if (!hayCambios) {
                throw new NegocioException("No se detectaron cambios para actualizar.");
            }

            estudianteDAO.actualizar(mapper.ConvertirAEntity(estudiante));
        } catch (PersistenciaException e) {
            throw new NegocioException("Error en persistencia: " + e.getMessage(), e);
        }
    }

    @Override
    public void eliminar(Long id) throws NegocioException {
        try {
            if (id == null || id <= 0) {
                throw new NegocioException("El ID proporcionado no es válido para eliminar.");
            }
            Estudiante estudiante = estudianteDAO.obtenerPorId(id);
            if (estudiante == null) {
                throw new NegocioException("No existe el estudiante.");
            }
            if (!estudiante.getLikesDados().isEmpty() || !estudiante.getLikesRecibidos().isEmpty()) {
                throw new NegocioException("No se puede eliminar un estudiante con likes activos.");
            }
            if (!estudiante.getMatches1().isEmpty() || !estudiante.getMatches2().isEmpty()) {
                throw new NegocioException("No se puede eliminar un estudiante con matches activos.");
            }
            estudianteDAO.eliminar(id);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error en persistencia: " + e.getMessage(), e);
        }
    }

    @Override
    public List<EstudianteDTO> buscarPorNombre(String nombre) throws NegocioException {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new NegocioException("Debe proporcionar un nombre para buscar.");
            }
            return mapper.ConvertirListaADto(estudianteDAO.buscarPorNombre(nombre));
        } catch (PersistenciaException e) {
            throw new NegocioException("Error en persistencia: " + e.getMessage(), e);
        }
    }

    @Override
    public List<EstudianteDTO> buscarPorHobby(Hobby hobby) throws NegocioException {
        try {
            if (hobby == null) {
                throw new NegocioException("Debe proporcionar un hobby para buscar.");
            }
            return mapper.ConvertirListaADto(estudianteDAO.buscarPorHobby(hobby));
        } catch (PersistenciaException e) {
            throw new NegocioException("Error en persistencia: " + e.getMessage(), e);
        }
    }

    @Override
    public EstudianteDTO autenticar(String correo, String contrasenia) throws NegocioException {
        try {
            if (correo == null || correo.trim().isEmpty()) {
                throw new NegocioException("El correo es obligatorio.");
            }
            if (!EMAIL_PATTERN.matcher(correo).matches()) {
                throw new NegocioException("El correo no tiene un formato válido.");
            }
            if (contrasenia == null || contrasenia.trim().isEmpty()) {
                throw new NegocioException("La contraseña es obligatoria.");
            }

            Estudiante estudiante = estudianteDAO.autenticar(correo, contrasenia);
            if (estudiante == null) {
                return null;
            }
            return mapper.ConvertirADto(estudiante);

        } catch (PersistenciaException e) {
            throw new NegocioException("Error en persistencia: " + e.getMessage(), e);
        }
    }

    // Métodos auxiliares
    private boolean equalsOrNull(String a, String b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return a.equals(b);
    }

    private boolean listEquals(List<?> list1, List<?> list2) {
        if (list1 == null && list2 == null) {
            return true;
        }
        if (list1 == null || list2 == null) {
            return false;
        }
        if (list1.size() != list2.size()) {
            return false;
        }
        return list1.containsAll(list2) && list2.containsAll(list1);
    }
}
