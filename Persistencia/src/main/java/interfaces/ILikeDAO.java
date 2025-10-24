package interfaces;

import entidades.Like;
import exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author brand
 */
public interface ILikeDAO {

    void agregar(Like like) throws PersistenciaException;

    void eliminar(Long id) throws PersistenciaException;

    void actualizar(Like like) throws PersistenciaException;

    Like obtenerPorId(Long id) throws PersistenciaException;

    List<Like> obtenerTodos() throws PersistenciaException;
}
