/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import entidades.Post;
import exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public interface IPostDAO {

    public void agregarPost(Post post) throws PersistenciaException;

    public Post actualizarPost(Post post) throws PersistenciaException;

    public void eliminarPost(long id) throws PersistenciaException;

    public List<Post> obtenerPostPorEstudiante(long idEstudiante) throws PersistenciaException;

    public List<Post> obtenerPostFeed() throws PersistenciaException;
    public Post actulizarReaccion(Post post)throws PersistenciaException;
    public boolean verificarReaccionEstudiante(Post post, long idEstudiante)throws PersistenciaException;
}
