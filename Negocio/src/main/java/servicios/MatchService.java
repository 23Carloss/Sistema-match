package servicios;

import DTOs.MatchDTO;
import Mappers.MatchMapper;
import entidades.Matches;
import exception.NegocioException;
import exception.PersistenciaException;
import interfaces.ILikeDAO;
import java.time.Instant;
import java.util.List;

/**
 * Servicio de Match que implementa la lógica de negocio para matches.
 *
 * @author brand
 */
public class MatchService implements IMatchService {

    private final IMatchService matchDAO;
    private final MatchMapper mapper;
    private final ILikeDAO likeDAO;

    public MatchService(IMatchService matchDAO, ILikeDAO likeDAO) {
        this.matchDAO = matchDAO;
        this.likeDAO = likeDAO;
        this.mapper = new MatchMapper();
    }

    @Override
    public void crear(MatchDTO match) throws NegocioException {
        try {
            if (match == null) {
                throw new NegocioException("El match no puede ser nulo.");
            }
            if (match.getEstudianteOrigen()== null || match.getEstudianteLikeado() == null) {
                throw new NegocioException("Ambos estudiantes son obligatorios para un Match.");
            }
            if (match.getEstudianteOrigen().getId().equals(match.getEstudianteLikeado().getId())) {
                throw new NegocioException("No pueden hacer match consigo mismo.");
            }
            if (match.getFechaHoraMatch() == null || match.getFechaHoraMatch().isAfter(Instant.now())) {
                throw new NegocioException("La fecha del match no puede ser futura.");
            }

            // Evitar matches duplicados
            List<MatchDTO> existentes = matchDAO.listar(100);
            boolean yaExiste = existentes.stream()
                    .anyMatch(m -> ((m.getEstudianteOrigen().getId().equals(match.getEstudianteOrigen().getId())
                    && m.getEstudianteLikeado().getId().equals(match.getEstudianteLikeado().getId()))
                    || (m.getEstudianteOrigen().getId().equals(match.getEstudianteLikeado().getId())
                    && m.getEstudianteLikeado().getId().equals(match.getEstudianteOrigen().getId()))));
            if (yaExiste) {
                throw new NegocioException("Ya existe un match entre estos estudiantes.");
            }

            // ***Validar que existan los Like recíprocos***
            boolean existeLike1 = likeDAO.existeLike(
                    match.getEstudianteOrigen().getId(), match.getEstudianteLikeado().getId());
            boolean existeLike2 = likeDAO.existeLike(
                    match.getEstudianteLikeado().getId(), match.getEstudianteOrigen().getId());

            if (!existeLike1 || !existeLike2) {
                throw new NegocioException("No existen likes recíprocos entre los estudiantes.");
            }
//
//            matchDAO.agregar(mapper.convertirAEntity(match));
        } catch (PersistenciaException e) {
            throw new NegocioException("Error en persistencia: " + e.getMessage(), e);
        }
    }

    @Override
    public MatchDTO buscarPorId(Long id) throws NegocioException {
//        try {
//            if (id == null || id <= 0) {
//                throw new NegocioException("ID no válido.");
//            }
////            Matches match = matchDAO.buscarPorId(id); es por la Interfaz
////            if (match == null) {
////                throw new NegocioException("No se encontró el Match con ID " + id);
////            }
////            return mapper.convertirADto(match);es por la Interfaz
//        return null;
//        } catch (PersistenciaException e) {
//            throw new NegocioException("Error en persistencia: " + e.getMessage(), e);
//        }
return null;
    }

    @Override
    public List<MatchDTO> listar(int limite) throws NegocioException {
//        try {
//            if (limite <= 0) {
//                throw new NegocioException("El límite debe ser mayor que cero.");
//            }
//            if (limite > 100) {
//                throw new NegocioException("El límite máximo permitido es 100.");
//            }
//            return mapper.convertirListaADto(matchDAO.listar(limite));
//        } catch (PersistenciaException e) {
//            throw new NegocioException("Error en persistencia: " + e.getMessage(), e);
//        }
return null;
    }

    @Override
    public void actualizar(MatchDTO match) throws NegocioException {
//        try {
//            if (match == null) {
//                throw new NegocioException("El match no puede ser nulo.");
//            }
//            if (match.getId() == null) {
//                throw new NegocioException("El ID es obligatorio para actualizar.");
//            }
//            Matches existente = matchDAO.obtenerPorId(match.getId());
//            if (existente == null) {
//                throw new NegocioException("No se encontró el Match con ID " + match.getId());
//            }
//            matchDAO.actualizar(mapper.convertirAEntity(match));
//        } catch (PersistenciaException e) {
//            throw new NegocioException("Error en persistencia: " + e.getMessage(), e);
//        }
    }

    @Override
    public void eliminar(Long id) throws NegocioException {
//        try {
//            if (id == null || id <= 0) {
//                throw new NegocioException("ID no válido para eliminar.");
//            }
//            matchDAO.eliminar(id);
//        } catch (PersistenciaException e) {
//            throw new NegocioException("Error en persistencia: " + e.getMessage(), e);
//        }
    }
}
