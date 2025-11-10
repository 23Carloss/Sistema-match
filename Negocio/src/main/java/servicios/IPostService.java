package servicios;

import DTOs.PostDTO;
import DTOs.EstudianteDTO;
import exception.NegocioException;
import java.util.List;

/**
 * Interfaz para la capa de servicios (BO) de Post. Define todas las operaciones
 * de negocio para posts.
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public interface IPostService {

    void agregarPost(PostDTO post) throws NegocioException;

    PostDTO actualizarPost(PostDTO post) throws NegocioException;

    void eliminarPost(long id) throws NegocioException;

    List<PostDTO> obtenerPostPorEstudiante(EstudianteDTO estudiante) throws NegocioException;

    List<PostDTO> obtenerPostFeed() throws NegocioException;

}
