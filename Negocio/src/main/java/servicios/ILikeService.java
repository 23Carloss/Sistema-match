package servicios;

import DTOs.LikeDTO;
import entidades.Likes;
import exception.NegocioException;
import java.util.List;

/**
 *
 * @author brand
 */
public interface ILikeService {

    void crear(LikeDTO like) throws NegocioException;

    LikeDTO buscarPorId(Long id) throws NegocioException;

    List<LikeDTO> listar(int limite) throws NegocioException;

    void actualizar(LikeDTO like) throws NegocioException;

    void eliminar(Long id) throws NegocioException;
}
