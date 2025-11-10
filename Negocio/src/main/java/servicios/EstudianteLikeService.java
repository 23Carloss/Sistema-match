package servicios;

import DTOs.EstudianteLikeDTO;
import Mappers.EstudianteLikeMapper;
import entidades.EstudianteLike;
import exception.NegocioException;
import exception.PersistenciaException;
import interfaces.IEstudianteLikeDAO;
import java.util.List;

/**
 *
 * @author brand
 */
public class EstudianteLikeService {

    private final IEstudianteLikeDAO estudianteLikeDAO;
    private final EstudianteLikeMapper mapper = new EstudianteLikeMapper();

    public EstudianteLikeService(IEstudianteLikeDAO estudianteLikeDAO) {
        this.estudianteLikeDAO = estudianteLikeDAO;
    }

    public void agregar(EstudianteLikeDTO dto) throws NegocioException {
//        if (dto == null || dto.getEstudiante() == null || dto.getLike() == null) {
//            throw new NegocioException("La relación debe tener estudiante y like.");
//        }
        try {
            estudianteLikeDAO.agregar(mapper.convertirAEntity(dto));
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al guardar relación estudiante-like: " + e.getMessage(), e);
        }
    }

    public void eliminar(Long id) throws NegocioException {
        if (id == null || id <= 0) {
            throw new NegocioException("ID inválido.");
        }
        try {
            estudianteLikeDAO.eliminar(id);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al eliminar relación: " + e.getMessage(), e);
        }
    }

    public List<EstudianteLikeDTO> listarPorEstudiante(Long estudianteId) throws NegocioException {
        try {
            List<EstudianteLike> lista = estudianteLikeDAO.listarPorEstudiante(estudianteId);
            return lista.stream().map(mapper::convertirADto).toList();
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al listar relaciones: " + e.getMessage(), e);
        }
    }

    public List<EstudianteLikeDTO> listarPorLike(Long likeId) throws NegocioException {
        try {
            List<EstudianteLike> lista = estudianteLikeDAO.listarPorLike(likeId);
            return lista.stream().map(mapper::convertirADto).toList();
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al listar relaciones: " + e.getMessage(), e);
        }
    }

    public EstudianteLikeDTO buscarPorId(Long id) throws NegocioException {
        try {
            EstudianteLike entity = estudianteLikeDAO.buscarPorId(id);
            return mapper.convertirADto(entity);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar relación: " + e.getMessage(), e);
        }
    }
}
