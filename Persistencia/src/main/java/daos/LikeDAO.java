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
    public List<Likes> listar(int limite) throws PersistenciaException {
        if (limite > 100) {
            throw new PersistenciaException("El límite máximo es 100 para listar");
        }
        try {
            TypedQuery<Likes> query = em.createQuery("SELECT l FROM Likes l", Likes.class);
            query.setMaxResults(limite);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al listar los Likes.", e);
        }
    }

    @Override
    public boolean existeLike(Long idOrigen, Long idDestino) throws PersistenciaException {
        try {
            TypedQuery<Long> query = em.createQuery(
                    "SELECT COUNT(l) FROM Likes l WHERE l.estudianteOrigen.id = :idOrigen AND l.estudianteDestino.id = :idDestino",
                    Long.class);
            query.setParameter("idOrigen", idOrigen);
            query.setParameter("idDestino", idDestino);
            Long count = query.getSingleResult();
            return count != null && count > 0;
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar like entre estudiantes.", e);
        }
    }

    @Override
    public List<Likes> obtenerTodos() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
