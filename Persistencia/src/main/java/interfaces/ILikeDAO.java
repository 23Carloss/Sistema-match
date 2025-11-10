package interfaces;

import entidades.Likes;
import exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author brand
 */
public interface ILikeDAO {

    public void agregar(Likes like) throws PersistenciaException;

    public void eliminar(Long id) throws PersistenciaException;

    public void actualizar(Likes like) throws PersistenciaException;

    public Likes obtenerPorId(Long id) throws PersistenciaException;

    List<Likes> listar(int limite) throws PersistenciaException;

    boolean existeLike(Long idOrigen, Long idDestino) throws PersistenciaException;


    public List<Likes> obtenerTodos() throws PersistenciaException;

}
