package interfaces;

import entidades.Matches;
import exception.PersistenciaException;
import java.util.List;

/**
 * 
 * @author brand
 */
public interface IMatchDAO {

    public void agregar(Matches match) throws PersistenciaException;

    public void eliminar(Long id) throws PersistenciaException;

    public void actualizar(Matches match) throws PersistenciaException;

    public Matches obtenerPorId(Long id) throws PersistenciaException;

    public List<Matches> listar(int limite) throws PersistenciaException;
}
