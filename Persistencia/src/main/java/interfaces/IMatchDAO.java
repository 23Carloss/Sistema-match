package interfaces;

import entidades.Matches;
import exception.PersistenciaException;
import java.util.List;

/**
 * 
 * @author brand
 */
public interface IMatchDAO {

    void agregar(Matches match) throws PersistenciaException;

    void eliminar(Long id) throws PersistenciaException;

    void actualizar(Matches match) throws PersistenciaException;

    Matches obtenerPorId(Long id) throws PersistenciaException;

    List<Matches> obtenerTodos() throws PersistenciaException;
}
