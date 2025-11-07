/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package BO;

import ConexionDB.conexionDB;
import DTOs.EstudianteDTO;
import Interfaces.IEstudianteBO;
import Mappers.EstudianteMapper;
import daos.EstudianteDAO;
import entidades.Estudiante;
import entidades.Hobby;
import exception.PersistenciaException;
import interfaces.IEstudianteDAO;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class EstudianteBO implements IEstudianteBO {
    
    private final IEstudianteDAO estudianteDAO;
    private EstudianteMapper mapper;
    
    
    
    public EstudianteBO(){
        estudianteDAO = new  EstudianteDAO(conexionDB.getEntityManager());
        mapper = new EstudianteMapper();
    }
    @Override
    public void AgregarEstudiante(EstudianteDTO estudiante){
        try{
            estudianteDAO.agregar(mapper.ConvertirAEntity(estudiante));
            JOptionPane msj = new JOptionPane("Usuario registrado con exito", JOptionPane.OK_OPTION);
            
        }catch(PersistenciaException e){
            JOptionPane msj = new JOptionPane("Error al agregar al usuario", JOptionPane.ERROR_MESSAGE);
           
        }
        
    }
    
    @Override
    public void ActualizarEstudiante(EstudianteDTO estudiante){
        try{
            estudianteDAO.actualizar(mapper.ConvertirAEntity(estudiante));
            JOptionPane msj = new JOptionPane("Usuario actulizado con exito", JOptionPane.OK_OPTION);
        }catch(PersistenciaException e){
            JOptionPane msj = new JOptionPane("Error al actualizar usuario", JOptionPane.ERROR_MESSAGE);
        }
    }
    @Override
    public void EliminarEstudiante(Long id){
        try {
            estudianteDAO.eliminar(id);
            JOptionPane msj = new JOptionPane("Usuario eliminado con exito", JOptionPane.OK_OPTION);
            
        } catch (PersistenciaException ex) {
            JOptionPane msj = new JOptionPane("Error al eliminar al usuario", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public EstudianteDTO BuscarPorId(Long id){
        try {
            return mapper.ConvertirADto(estudianteDAO.obtenerPorId(id));
        } catch (PersistenciaException ex) {
            JOptionPane msj = new JOptionPane("Error al encontrar al usuario", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    @Override
    public List<EstudianteDTO> BuscarPorNombre(String nombre){
        try {
            return mapper.ConvertirListaADto(estudianteDAO.buscarPorNombre(nombre));
        } catch (PersistenciaException ex) {
            JOptionPane msj = new JOptionPane("Error al buscar los usuarios", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    @Override
    public List<EstudianteDTO> ObtenerTodos(){
        try {
            return mapper.ConvertirListaADto(estudianteDAO.obtenerTodos());
        } catch (PersistenciaException ex) {
            JOptionPane msj = new JOptionPane("Error al buscar los usuarios", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
    }
    
    @Override
    public List<EstudianteDTO> BuscarPorHobby(Hobby hobby){
        try {
            return mapper.ConvertirListaADto(estudianteDAO.buscarPorHobby(hobby));
        } catch (PersistenciaException ex) {
            JOptionPane msj = new JOptionPane("Error al buscar los usuarios", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
    }

    @Override
    public EstudianteDTO autenticar(String correo, String contrasenia) {
        Estudiante estudiante = estudianteDAO.autenticar(correo, contrasenia);
        if(estudiante == null){
            return null;
        }
        return mapper.ConvertirADto(estudianteDAO.autenticar(correo, contrasenia));
    }

    
}
