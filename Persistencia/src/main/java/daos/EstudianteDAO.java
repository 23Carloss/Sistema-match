package daos;

import entidades.Estudiante;
import entidades.Hobby;
import exception.PersistenciaException;
import interfaces.IEstudianteDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
    public List<Estudiante> listar(int limite) throws PersistenciaException {
        if (limite > 100) {
            throw new PersistenciaException("El límite máximo es 100");
        }
        try {
            TypedQuery<Estudiante> query = em.createQuery("SELECT e FROM Estudiante e", Estudiante.class);
            query.setMaxResults(limite);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al listar estudiantes", e);
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

    @Override
    public Estudiante autenticar(String correo, String contrasenia) {
        Estudiante estudianteEncontrado;
        try {
            estudianteEncontrado = buscarPorCorreo(correo);
            if(estudianteEncontrado == null){
                JOptionPane.showMessageDialog(null,"Estudiante no encontrado","Error" ,JOptionPane.ERROR_MESSAGE);
                return null;
            }
            
            if(estudianteEncontrado.getCorreo().equals(correo) && estudianteEncontrado.getContrasenia().equals(contrasenia)){    
                return estudianteEncontrado;
            }else{
                JOptionPane.showMessageDialog(null,"Error en las credenciales","Error" ,JOptionPane.ERROR_MESSAGE);
            }
        }
         catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return null;
    }
    
    private Estudiante buscarPorCorreo(String correo) throws PersistenciaException {
        try {
            return em.createQuery("Select e from Estudiante e where e.correo = :correo", Estudiante.class)
                    .setParameter("correo", correo)
                    .getSingleResult();
        } catch (Exception e) {
            throw new PersistenciaException("Correo no encontrado", e);
            
        }
    }
}
