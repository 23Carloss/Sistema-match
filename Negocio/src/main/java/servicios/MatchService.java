package servicios;

import DTOs.MatchDTO;
import Mappers.MatchMapper;
import entidades.Matches;
import exception.NegocioException;
import exception.PersistenciaException;
import interfaces.ILikeDAO;
import interfaces.IMatchDAO;
import java.util.List;

/**
 * Servicio de Match que implementa la lógica de negocio para matches.
 *
 * @author brand
 */
public class MatchService implements IMatchService {

    private final IMatchDAO matchDAO;
    private final MatchMapper mapper;
    private final ILikeDAO likeDAO;

    public MatchService(IMatchDAO matchDAO, ILikeDAO likeDAO) {
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
            if (match.getEstudiante1() == null || match.getEstudiante2() == null) {
                throw new NegocioException("Ambos estudiantes son obligatorios para un Match.");
            }
            if (match.getEstudiante1().getId().equals(match.getEstudiante2().getId())) {
                throw new NegocioException("No pueden hacer match consigo mismo.");
            }
            if (match.getFechaHoraMatch() == null || match.getFechaHoraMatch().isAfter(java.time.LocalDateTime.now())) {
                throw new NegocioException("La fecha del match no puede ser futura.");
            }

            // Evitar matches duplicados
            List<Matches> existentes = matchDAO.listar(100);
            boolean yaExiste = existentes.stream()
                    .anyMatch(m -> ((m.getEstudiante1().getIdEstudiante().equals(match.getEstudiante1().getId())
                    && m.getEstudiante2().getIdEstudiante().equals(match.getEstudiante2().getId()))
                    || (m.getEstudiante1().getIdEstudiante().equals(match.getEstudiante2().getId())
                    && m.getEstudiante2().getIdEstudiante().equals(match.getEstudiante1().getId()))));
            if (yaExiste) {
                throw new NegocioException("Ya existe un match entre estos estudiantes.");
            }

            // ***Validar que existan los Like recíprocos***
            boolean existeLike1 = likeDAO.existeLike(
                    match.getEstudiante1().getId(), match.getEstudiante2().getId());
            boolean existeLike2 = likeDAO.existeLike(
                    match.getEstudiante2().getId(), match.getEstudiante1().getId());

            if (!existeLike1 || !existeLike2) {
                throw new NegocioException("No existen likes recíprocos entre los estudiantes.");
            }

            matchDAO.agregar(mapper.convertirAEntity(match));
        } catch (PersistenciaException e) {
            throw new NegocioException("Error en persistencia: " + e.getMessage(), e);
        }
    }

    @Override
    public MatchDTO buscarPorId(Long id) throws NegocioException {
        try {
            if (id == null || id <= 0) {
                throw new NegocioException("ID no válido.");
            }
            Matches match = matchDAO.obtenerPorId(id);
            if (match == null) {
                throw new NegocioException("No se encontró el Match con ID " + id);
            }
            return mapper.convertirADto(match);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error en persistencia: " + e.getMessage(), e);
        }
    }

    @Override
    public List<MatchDTO> listar(int limite) throws NegocioException {
        try {
            if (limite <= 0) {
                throw new NegocioException("El límite debe ser mayor que cero.");
            }
            if (limite > 100) {
                throw new NegocioException("El límite máximo permitido es 100.");
            }
            return mapper.convertirListaADto(matchDAO.listar(limite));
        } catch (PersistenciaException e) {
            throw new NegocioException("Error en persistencia: " + e.getMessage(), e);
        }
    }

    @Override
    public void actualizar(MatchDTO match) throws NegocioException {
        try {
            if (match == null) {
                throw new NegocioException("El match no puede ser nulo.");
            }
            if (match.getId() == null) {
                throw new NegocioException("El ID es obligatorio para actualizar.");
            }
            Matches existente = matchDAO.obtenerPorId(match.getId());
            if (existente == null) {
                throw new NegocioException("No se encontró el Match con ID " + match.getId());
            }
            matchDAO.actualizar(mapper.convertirAEntity(match));
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
            matchDAO.eliminar(id);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error en persistencia: " + e.getMessage(), e);
        }
    }
}
