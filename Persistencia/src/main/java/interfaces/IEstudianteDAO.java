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

    void agregar(Estudiante estudiante) throws PersistenciaException;

    void eliminar(Long id) throws PersistenciaException;

    void actualizar(Estudiante estudiante) throws PersistenciaException;

    Estudiante obtenerPorId(Long id) throws PersistenciaException;

    List<Estudiante> obtenerTodos() throws PersistenciaException;

    List<Estudiante> buscarPorNombre(String nombre) throws PersistenciaException;

    List<Estudiante> buscarPorHobby(Hobby hobby) throws PersistenciaException;
}
