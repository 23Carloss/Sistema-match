package daos;

import entidades.Like;
import exception.PersistenciaException;
import interfaces.ILikeDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author brand
 */
public class LikeDAO implements ILikeDAO {

    private EntityManager em;

    public LikeDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public void agregar(Like like) throws PersistenciaException {
        try {
            em.getTransaction().begin();
            em.persist(like);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al agregar el Like.", e);
        }
    }

    @Override
    public void eliminar(Long id) throws PersistenciaException {
        try {
            em.getTransaction().begin();
            Like like = em.find(Like.class, id);
            if (like != null) {
                em.remove(like);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al eliminar el Like.", e);
        }
    }

    @Override
    public void actualizar(Like like) throws PersistenciaException {
        try {
            em.getTransaction().begin();
            em.merge(like);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al actualizar el Like.", e);
        }
    }

    @Override
    public Like obtenerPorId(Long id) throws PersistenciaException {
        try {
            return em.find(Like.class, id);
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener Like por ID.", e);
        }
    }

    @Override
    public List<Like> obtenerTodos() throws PersistenciaException {
        try {
            TypedQuery<Like> query = em.createQuery("SELECT l FROM Like l", Like.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener todos los Likes.", e);
        }
    }
}
