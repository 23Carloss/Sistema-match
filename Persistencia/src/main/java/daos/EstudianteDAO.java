package daos;

import entidades.Estudiante;
import entidades.Hobby;
import exception.PersistenciaException;
import interfaces.IEstudianteDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 * 
 * @author brand
 */
public class EstudianteDAO implements IEstudianteDAO {

    private EntityManager em;

    public EstudianteDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public void agregar(Estudiante estudiante) throws PersistenciaException {
        try {
            em.getTransaction().begin();
            em.persist(estudiante);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al agregar el estudiante.", e);
        }
    }

    @Override
    public void eliminar(Long id) throws PersistenciaException {
        try {
            em.getTransaction().begin();
            Estudiante estudiante = em.find(Estudiante.class, id);
            if (estudiante != null) {
                em.remove(estudiante);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al eliminar el estudiante.", e);
        }
    }

    @Override
    public void actualizar(Estudiante estudiante) throws PersistenciaException {
        try {
            em.getTransaction().begin();
            em.merge(estudiante);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al actualizar el estudiante.", e);
        }
    }

    @Override
    public Estudiante obtenerPorId(Long id) throws PersistenciaException {
        try {
            return em.find(Estudiante.class, id);
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener el estudiante por ID.", e);
        }
    }

    @Override
    public List<Estudiante> obtenerTodos() throws PersistenciaException {
        try {
            TypedQuery<Estudiante> query = em.createQuery("SELECT e FROM Estudiante e", Estudiante.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener todos los estudiantes.", e);
        }
    }

    @Override
    public List<Estudiante> buscarPorNombre(String nombre) throws PersistenciaException {
        try {
            TypedQuery<Estudiante> query = em.createQuery(
                    "SELECT e FROM Estudiante e WHERE LOWER(e.nombre) LIKE LOWER(:nombre)", Estudiante.class); // el LIKE LOWER en sql permite que coincida lo que se busca con lo que se ingresa sin que haya una diferencia entre mayúsculas y minúsculas (ejemplo: roBerto y Roberto)
            query.setParameter("nombre", "%" + nombre + "%");
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar estudiantes por nombre.", e);
        }
    }

    @Override
    public List<Estudiante> buscarPorHobby(Hobby hobby) throws PersistenciaException {
        try {
            TypedQuery<Estudiante> query = em.createQuery(
                    "SELECT e FROM Estudiante e JOIN e.hobby h WHERE h = :hobby", Estudiante.class);
            query.setParameter("hobby", hobby);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar estudiantes por hobby.", e);
        }
    }
}
