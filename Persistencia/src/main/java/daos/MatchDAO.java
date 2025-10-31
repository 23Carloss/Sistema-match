package daos;

import entidades.Matches;
import exception.PersistenciaException;
import interfaces.IMatchDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 * 
 * @author brand
 */
public class MatchDAO implements IMatchDAO {

    private EntityManager em;

    public MatchDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public void agregar(Matches match) throws PersistenciaException {
        try {
            em.getTransaction().begin();
            em.persist(match);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al agregar el Match.", e);
        }
    }

    @Override
    public void eliminar(Long id) throws PersistenciaException {
        try {
            em.getTransaction().begin();
            Matches match = em.find(Matches.class, id);
            if (match != null) {
                em.remove(match);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al eliminar el Match.", e);
        }
    }

    @Override
    public void actualizar(Matches match) throws PersistenciaException {
        try {
            em.getTransaction().begin();
            em.merge(match);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al actualizar el Match.", e);
        }
    }

    @Override
    public Matches obtenerPorId(Long id) throws PersistenciaException {
        try {
            return em.find(Matches.class, id);
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener Match por ID.", e);
        }
    }

    @Override
    public List<Matches> obtenerTodos() throws PersistenciaException {
        try {
            TypedQuery<Matches> query = em.createQuery("SELECT m FROM Match m", Matches.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener todos los Matches.", e);
        }
    }
}
