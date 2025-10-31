package interfaces;

import entidades.Likes;
import exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author brand
 */
public interface ILikeDAO {

    void agregar(Likes like) throws PersistenciaException;

    void eliminar(Long id) throws PersistenciaException;

    void actualizar(Likes like) throws PersistenciaException;

    Likes obtenerPorId(Long id) throws PersistenciaException;

    List<Likes> obtenerTodos() throws PersistenciaException;
}
