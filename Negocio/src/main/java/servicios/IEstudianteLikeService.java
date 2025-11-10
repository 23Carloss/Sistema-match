package servicios;

import DTOs.EstudianteLikeDTO;
import exception.NegocioException;
import java.util.List;

/**
 * 
 * @author brand
 */
public interface IEstudianteLikeService {

    void agregar(EstudianteLikeDTO dto) throws NegocioException;

    void eliminar(Long id) throws NegocioException;

    List<EstudianteLikeDTO> listarPorEstudiante(Long estudianteId) throws NegocioException;

    List<EstudianteLikeDTO> listarPorLike(Long likeId) throws NegocioException;

    EstudianteLikeDTO buscarPorId(Long id) throws NegocioException;
}
