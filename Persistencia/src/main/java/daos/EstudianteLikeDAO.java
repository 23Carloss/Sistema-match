package daos;

import entidades.EstudianteLike;
import exception.PersistenciaException;
import interfaces.IEstudianteLikeDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class EstudianteLikeDAO implements IEstudianteLikeDAO {

    private final EntityManager em;

    public EstudianteLikeDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public EstudianteLike agregar(EstudianteLike entity) throws PersistenciaException {
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al agregar relación Estudiante-Like", e);
        }
    }

    @Override
    public void eliminar(Long id) throws PersistenciaException {
        try {
            em.getTransaction().begin();
            EstudianteLike entity = em.find(EstudianteLike.class, id);
            if (entity != null) {
                em.remove(entity);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al eliminar relación Estudiante-Like", e);
        }
    }

    @Override
    public List<EstudianteLike> listarPorEstudiante(Long estudianteId) throws PersistenciaException {
        try {
            TypedQuery<EstudianteLike> query = em.createQuery(
                    "SELECT el FROM EstudianteLike el WHERE el.estudiante.id = :id", EstudianteLike.class);
            query.setParameter("id", estudianteId);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al listar por estudiante", e);
        }
    }

    @Override
    public List<EstudianteLike> listarPorLike(Long likeId) throws PersistenciaException {
        try {
            TypedQuery<EstudianteLike> query = em.createQuery(
                    "SELECT el FROM EstudianteLike el WHERE el.like.id = :id", EstudianteLike.class);
            query.setParameter("id", likeId);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al listar por like", e);
        }
    }

    @Override
    public EstudianteLike buscarPorId(Long id) throws PersistenciaException {
        try {
            return em.find(EstudianteLike.class, id);
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar relación por id", e);
        }
    }
    @Override
    public boolean existeEstudianteLike(long idOrigen, long idDestino) throws PersistenciaException {
        try {
            TypedQuery<EstudianteLike> query = em.createQuery(
                "SELECT el FROM EstudianteLike el WHERE el.estudianteOrigen.id = :idOrigen AND el.estudianteDestino.id = :idDestino",
                EstudianteLike.class
            );
            query.setParameter("idOrigen", idOrigen);
            query.setParameter("idDestino", idDestino);
            return !query.getResultList().isEmpty();
        } catch (Exception e) {
            throw new PersistenciaException("Error al verificar EstudianteLike", e);
        }
    }   

}
