/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package BO;

import ConexionDB.conexionDB;
import DTOs.EstudianteDTO;
import DTOs.PostDTO;
import Interfaces.IPostBO;
import Mappers.PostMapper;
import daos.PostDAO;
import entidades.Post;
import exception.PersistenciaException;
import interfaces.IPostDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class PostBO implements IPostBO{
    private final IPostDAO postDAO;
    private PostMapper mapper;
    
    public PostBO(){
        this.postDAO = new PostDAO(conexionDB.getEntityManager());
        this.mapper = new PostMapper();
    }
    
    public void agregarPost(PostDTO post){
        try {
            postDAO.agregarPost(mapper.convertirAEntity(post));
            JOptionPane.showMessageDialog(null,"Post publicado con exito","Exito", JOptionPane.OK_OPTION);
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null,"Error al publicar post","Error", JOptionPane.OK_OPTION);
        }
    }
    
    @Override
    public PostDTO actualizarPost(PostDTO post){
        try {
            Post postActualizado = postDAO.actualizarPost(mapper.convertirAEntity(post));
            JOptionPane.showMessageDialog(null,"Post publicado con exito","Exito", JOptionPane.OK_OPTION);
            return mapper.convertirADto(postActualizado);
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null,"Error al actualizar post","Error", JOptionPane.OK_OPTION);
            return null;
        }
    }
    
    public List<PostDTO> obtenerPostPorEstudiante(EstudianteDTO estudiante){
        try {
            return mapper.convertirLista(postDAO.obtenerPostPorEstudiante(estudiante.getId()));
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null,"Error al obtener post del estudiante","Error", JOptionPane.OK_OPTION);
            return null;
        }
        // PON SOUT PARA SABER DESDE DONDE SE PIERDE EL ESTUDIANTE, FIJARSE PRIMERO DESDE EL LOG IN HASTA QUE LLEGA A LA BO
    }
    
    @Override
    public List<PostDTO> obtenerPostFeed(){
        try {
            return mapper.convertirLista(postDAO.obtenerPostFeed());
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null,"Error al obtener post","Error", JOptionPane.OK_OPTION);
            return null;
        }
        
    }

    @Override
    public void eliminarPost(long id) {
        try {
            postDAO.eliminarPost(id);
            JOptionPane.showMessageDialog(null,"Post eliminado con exito","Exito", JOptionPane.OK_OPTION);
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null,"Error al eliminar post","Error", JOptionPane.OK_OPTION);
        }
    }



}
