package interfaces;

import entidades.Match;
import exception.PersistenciaException;
import java.util.List;

/**
 * 
 * @author brand
 */
public interface IMatchDAO {

    void agregar(Match match) throws PersistenciaException;

    void eliminar(Long id) throws PersistenciaException;

    void actualizar(Match match) throws PersistenciaException;

    Match obtenerPorId(Long id) throws PersistenciaException;

    List<Match> obtenerTodos() throws PersistenciaException;
}
