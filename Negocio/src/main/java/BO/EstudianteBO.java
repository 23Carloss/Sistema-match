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
            JOptionPane.showMessageDialog(null, "Estudiante no puede estar vacío", "Error en validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (estudiante.getNombre() == null || estudiante.getNombre().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo nombre no puede estar vac[io", "Error al validar", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (estudiante.getCorreo() == null || estudiante.getCorreo().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El correo no puede estar vac[io", "Error en validacion", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (estudiante.getContrasenia() == null || estudiante.getContrasenia().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "La contraseña no puede estar vac[ia", "Error en validacion", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (estudiante.getContrasenia().length() < 8) {
            JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos 9 caracteres.", "Error al validar", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (estudiante.getCarrera()== null) {
            JOptionPane.showMessageDialog(null, "Ingrese la carrera que est[a cursando", "Error al validar", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String regexCorreo = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!Pattern.matches(regexCorreo, estudiante.getCorreo())) {
            JOptionPane.showMessageDialog(null, "El formato del correo no es válido.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
    

    @Override
    public void AgregarEstudiante(EstudianteDTO estudiante) {
        try {
            estudianteDAO.agregar(mapper.ConvertirAEntity(estudiante));
            JOptionPane.showMessageDialog(null, "Usuario registrado con exito", "Exito", JOptionPane.OK_OPTION);
        } catch (PersistenciaException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar al usuario", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

    @Override
    public void ActualizarEstudiante(EstudianteDTO estudiante) {
        try {
            estudianteDAO.actualizar(mapper.ConvertirAEntity(estudiante));
            JOptionPane.showConfirmDialog(null, "Usuario actulizado con exito", "Exito", JOptionPane.OK_OPTION);
        } catch (PersistenciaException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void EliminarEstudiante(Long id) {
        try {
            estudianteDAO.eliminar(id);
            JOptionPane msj = new JOptionPane("Usuario eliminado con exito", JOptionPane.OK_OPTION);

        } catch (PersistenciaException ex) {
            JOptionPane msj = new JOptionPane("Error al eliminar al usuario", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public EstudianteDTO BuscarPorId(Long id) {
        try {
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

//    @Override
//    public List<EstudianteDTO> ObtenerTodos(){
//        try {
//            return mapper.ConvertirListaADto(estudianteDAO.obtenerTodos());
//        } catch (PersistenciaException ex) {
//            JOptionPane msj = new JOptionPane("Error al buscar los usuarios", JOptionPane.ERROR_MESSAGE);
//            return null;
//        }
//        
//    }
//    
    @Override
    public List<EstudianteDTO> BuscarPorHobby(Hobby hobby) {
        try {
            return mapper.ConvertirListaADto(estudianteDAO.buscarPorHobby(hobby));
        } catch (PersistenciaException ex) {
            JOptionPane msj = new JOptionPane("Error al buscar los usuarios", JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }

    @Override
    public EstudianteDTO autenticar(String correo, String contrasenia) {
        try {
            Estudiante estudiante = estudianteDAO.autenticar(correo, contrasenia);
            if (estudiante == null) {
                return null;
            }
            return mapper.ConvertirADto(estudianteDAO.autenticar(correo, contrasenia));
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

}
