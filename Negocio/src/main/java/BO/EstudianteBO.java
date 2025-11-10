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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class EstudianteBO implements IEstudianteBO {

    private final IEstudianteDAO estudianteDAO;
    private EstudianteMapper mapper;

    public EstudianteBO() {
        estudianteDAO = new EstudianteDAO(conexionDB.getEntityManager());
        mapper = new EstudianteMapper();

    }

    private boolean validarEstudiante(EstudianteDTO estudiante) {
        if (estudiante == null) {
            JOptionPane.showMessageDialog(null, "Estudiante no puede estar vacio", "Error en validacipn", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (estudiante.getNombre() == null || estudiante.getNombre().trim().isEmpty() 
                || estudiante.getApellidoPaterno().trim().isEmpty()
                || estudiante.getApellidoMaterno().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo nombre no puede estar vacio", "Error al validar", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (estudiante.getCorreo() == null || estudiante.getCorreo().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El correo no puede estar vacio", "Error en validacion", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (estudiante.getContrasenia() == null || estudiante.getContrasenia().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "La contraseña no puede estar vacia", "Error en validacion", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (estudiante.getContrasenia().length() < 8) {
            JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos 9 caracteres.", "Error al validar", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (estudiante.getCarrera()== null) {
            JOptionPane.showMessageDialog(null, "Ingrese la carrera que esta cursando", "Error al validar", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String regexCorreo = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!Pattern.matches(regexCorreo, estudiante.getCorreo())) {
            JOptionPane.showMessageDialog(null, "El formato del correo no es valido.", "Error de validacion", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
    

    @Override
    public void AgregarEstudiante(EstudianteDTO estudiante) {
        try {
            if(validarEstudiante(estudiante)){
                 estudianteDAO.agregar(mapper.ConvertirAEntity(estudiante));
                JOptionPane.showMessageDialog(null, "Usuario registrado con exito", "Exito", JOptionPane.YES_OPTION);
            }           
        } catch (PersistenciaException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar al usuario", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

    @Override
    public void ActualizarEstudiante(EstudianteDTO estudiante) {
        try {
            if(validarEstudiante(estudiante)){
                estudianteDAO.actualizar(mapper.ConvertirAEntity(estudiante));
                JOptionPane.showMessageDialog(null, "Usuario actulizado con exito", "Exito", JOptionPane.YES_OPTION);
            }  
            
        } catch (PersistenciaException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void EliminarEstudiante(Long id) {
        try {
            if (id <= 0) {
                JOptionPane.showMessageDialog(null, "ID inválido", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            estudianteDAO.eliminar(id);
            JOptionPane.showMessageDialog(null, "Usuario eliminado con exito", "Error", JOptionPane.YES_OPTION);
  
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar al usuario", "Error",JOptionPane.ERROR_MESSAGE);
            
        }
    }

    @Override
    public EstudianteDTO BuscarPorId(Long id) {
        try {
            if (id <= 0) {
                JOptionPane.showMessageDialog(null, "ID inválido", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            Estudiante estudiante = estudianteDAO.obtenerPorId(id);
            if (estudiante == null) {
                return null;
            }
            return mapper.ConvertirADto(estudiante);
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null, "Error al encontrar al usuario", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    @Override
    public List<EstudianteDTO> BuscarPorNombre(String nombre) {
        try {
            return mapper.ConvertirListaADto(estudianteDAO.buscarPorNombre(nombre));
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar los usuarios", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    @Override
    public List<EstudianteDTO> BuscarPorHobby(Hobby hobby) {
        try {
            return mapper.ConvertirListaADto(estudianteDAO.buscarPorHobby(hobby));
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar los usuarios", "Error al validar", JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }

    @Override
    public EstudianteDTO autenticar(String correo, String contrasenia) {
        try {
            Estudiante estudiante = estudianteDAO.autenticar(correo, contrasenia);
            if (estudiante == null) {
                JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            return mapper.ConvertirADto(estudianteDAO.autenticar(correo, contrasenia));
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

}
