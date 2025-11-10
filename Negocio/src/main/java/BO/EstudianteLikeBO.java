/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package BO;

import ConexionDB.conexionDB;
import DTOs.EstudianteDTO;
import DTOs.EstudianteLikeDTO;
import Interfaces.IEstudianteLikeBO;
import Mappers.EstudianteLikeMapper;
import daos.EstudianteLikeDAO;
import exception.PersistenciaException;
import interfaces.IEstudianteLikeDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class EstudianteLikeBO implements IEstudianteLikeBO{
    private IEstudianteLikeDAO estudianteLikeDAO;
    private EstudianteLikeMapper mapper;

    public EstudianteLikeBO() {
        estudianteLikeDAO = new EstudianteLikeDAO(conexionDB.getEntityManager());
        mapper =new EstudianteLikeMapper();
    }
    
    private boolean validarEstudianteLike(EstudianteLikeDTO like){
        if (true) {
            
        }
        return true;
    }
    
    @Override
    public EstudianteLikeDTO agregarEstudianteLike(EstudianteLikeDTO estudianteLike) {
        try {
            
            
            JOptionPane.showMessageDialog(null,"Like al estudiante enviado con exito","Exito", JOptionPane.OK_OPTION);
            return mapper.convertirADto(estudianteLikeDAO.agregar(mapper.convertirAEntity(estudianteLike)));
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null,"Error al enviar Like al estudiante ","Error", JOptionPane.OK_OPTION);
            return null;
        }
      
    }

    @Override
    public void eliminarEstudianteLike(long id) {
        try {
            estudianteLikeDAO.eliminar(id);
            JOptionPane.showMessageDialog(null,"Like al estudiante eliminado con exito","Exito", JOptionPane.OK_OPTION);
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null,"Error al eliminar Like al estudiante ","Error", JOptionPane.OK_OPTION);
        }
    }

    @Override
    public boolean existeEstudianteLike(EstudianteDTO origen, EstudianteDTO destino) {
       try {
            estudianteLikeDAO.existeEstudianteLike(origen.getId(), destino.getId());
            JOptionPane.showMessageDialog(null,"Like al estudiante eliminado con exito","Exito", JOptionPane.OK_OPTION);
            return true;
        } catch (PersistenciaException e) {
            JOptionPane.showMessageDialog(null,"Error al eliminar Like al estudiante ","Error", JOptionPane.OK_OPTION);
            return false;
        }
    }
    

}
