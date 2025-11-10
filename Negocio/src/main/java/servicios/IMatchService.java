package servicios;

import DTOs.MatchDTO;
import entidades.Matches;
import exception.NegocioException;
import java.util.List;

/**
 *
 * @author brand
 */
public interface IMatchService {

    void crear(MatchDTO match) throws NegocioException;

    MatchDTO buscarPorId(Long id) throws NegocioException;

    List<MatchDTO> listar(int limite) throws NegocioException;

    void actualizar(MatchDTO match) throws NegocioException;

    void eliminar(Long id) throws NegocioException;
}
