/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package daos;

import entidades.Post;
import exception.PersistenciaException;
import interfaces.IPostDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class PostDAO implements IPostDAO {
    
private EntityManager em;

    public PostDAO(EntityManager em){
        this.em = em;
        
    }
    @Override
    public void agregarPost(Post post) throws PersistenciaException {
        try{
            em.getTransaction().begin();
            em.persist(post);
            em.getTransaction().commit();
            
        }catch(Exception e){
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al publicar post");
        }
    }

    @Override
    public Post actualizarPost(Post post) throws PersistenciaException {
        try{
            em.getTransaction().begin();
            em.merge(post);
            em.getTransaction().commit();
            return post;
        }catch(Exception e){
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al actualizar post");
        }
    }
    

    @Override
    public void eliminarPost(long id) throws PersistenciaException {
        
        try{
            em.getTransaction().begin();
            Post post = em.find(Post.class, id);
            if (post != null) {
                em.remove(post);
            }
        em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al eliminar post");
        }
    }
    

    @Override
    public List<Post> obtenerPostPorEstudiante(long idEstudiante) throws PersistenciaException {
        try {
            TypedQuery<Post> query = em.createQuery(
                    "SELECT e FROM Post e WHERE (e.id_Estudiante) LIKE (:idEstudiante)", Post.class); // el LIKE LOWER en sql permite que coincida lo que se busca con lo que se ingresa sin que haya una diferencia entre mayúsculas y minúsculas (ejemplo: roBerto y Roberto)
            query.setParameter("idEstudiante", idEstudiante);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar post por estudiantes", e);
        }
    }

    @Override
    public List<Post> obtenerPostFeed() throws PersistenciaException {
      try {
            TypedQuery<Post> query = em.createQuery("SELECT p FROM Post p", Post.class); 
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener post", e);
        }
    }

}
