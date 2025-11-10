package servicios;

import DTOs.EstudianteDTO;
import entidades.Estudiante;
import entidades.Hobby;
import exception.NegocioException;
import java.util.List;

/**
 * 
 * @author brand
 */
public interface IEstudianteService {

    void crear(EstudianteDTO estudiante) throws NegocioException;

    EstudianteDTO buscarPorId(Long id) throws NegocioException;

    List<EstudianteDTO> listar(int limite) throws NegocioException;

    void actualizar(EstudianteDTO estudiante) throws NegocioException;

    void eliminar(Long id) throws NegocioException;

    List<EstudianteDTO> buscarPorNombre(String nombre) throws NegocioException;

    List<EstudianteDTO> buscarPorHobby(Hobby hobby) throws NegocioException;
    
    EstudianteDTO autenticar(String correo, String contrasenia) throws NegocioException;
}
