package interfaces;

import entidades.Estudiante;
import entidades.Hobby;
import exception.PersistenciaException;
import java.util.List;

/**
 * 
 * @author brand
 */
public interface IEstudianteDAO {

    public void agregar(Estudiante estudiante) throws PersistenciaException;

    public void eliminar(Long id) throws PersistenciaException;

    public void actualizar(Estudiante estudiante) throws PersistenciaException;

    public Estudiante obtenerPorId(Long id) throws PersistenciaException;

    List<Estudiante> listar(int limite) throws PersistenciaException;
    public List<Estudiante> obtenerTodos() throws PersistenciaException;

    public List<Estudiante> buscarPorNombre(String nombre) throws PersistenciaException;

    List<Estudiante> buscarPorHobby(Hobby hobby) throws PersistenciaException;
}
    public List<Estudiante> buscarPorHobby(Hobby hobby) throws PersistenciaException;
    
    public Estudiante autenticar(String correo,String contrasenia);
}
