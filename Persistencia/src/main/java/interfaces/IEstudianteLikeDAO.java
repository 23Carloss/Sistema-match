package interfaces;

import entidades.EstudianteLike;
import exception.PersistenciaException;
import java.util.List;

/**
 * 
 * @author brand
 */
public interface IEstudianteLikeDAO {

    void agregar(EstudianteLike entity) throws PersistenciaException;

    void eliminar(Long id) throws PersistenciaException;

    List<EstudianteLike> listarPorEstudiante(Long estudianteId) throws PersistenciaException;

    List<EstudianteLike> listarPorLike(Long likeId) throws PersistenciaException;

    EstudianteLike buscarPorId(Long id) throws PersistenciaException;
}
