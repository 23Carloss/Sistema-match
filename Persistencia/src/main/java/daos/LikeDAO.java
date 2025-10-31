package daos;

import entidades.Likes;
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
    public void agregar(Likes like) throws PersistenciaException {
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
            Likes like = em.find(Likes.class, id);
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
    public void actualizar(Likes like) throws PersistenciaException {
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
    public Likes obtenerPorId(Long id) throws PersistenciaException {
        try {
            return em.find(Likes.class, id);
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener Like por ID.", e);
        }
    }

    @Override
    public List<Likes> obtenerTodos() throws PersistenciaException {
        try {
            TypedQuery<Likes> query = em.createQuery("SELECT l FROM Like l", Likes.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener todos los Likes.", e);
        }
    }
}
