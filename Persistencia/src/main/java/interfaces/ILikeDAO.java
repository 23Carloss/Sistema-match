package interfaces;

import entidades.Likes;
import entidades.Post;
import exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author brand
 */
public interface ILikeDAO {

    public Likes agregar(Likes like) throws PersistenciaException;

    public void eliminar(Long id) throws PersistenciaException;

    public void actualizar(Likes like) throws PersistenciaException;

    public Likes obtenerPorId(Long id) throws PersistenciaException;

    List<Likes> listar(int limite) throws PersistenciaException;

    boolean existeLike(Long idOrigen, Long idDestino) throws PersistenciaException;

    public Likes buscarLikeEntreEstudiantes(long idEstudiante1, long idEstudiante2) throws PersistenciaException;
    
    public List<Likes> obtenerTodos() throws PersistenciaException;
    
    public boolean verificarReaccionEstudiante(Post post, long idEstudiante) throws PersistenciaException;

    public Likes buscarLike(Long postId, Long estudianteId) throws PersistenciaException;
}
