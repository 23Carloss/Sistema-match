/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package BO;

import ConexionDB.conexionDB;
import DTOs.LikeDTO;
import Interfaces.ILikeBO;
import Mappers.LikeMapper;
import daos.LikeDAO;
import exception.PersistenciaException;
import interfaces.ILikeDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class LikeBO implements ILikeBO {
    private ILikeDAO likeDAO;
    private LikeMapper mapper;

    public LikeBO() {
        likeDAO = new LikeDAO(conexionDB.getEntityManager());
        mapper = new LikeMapper();
    }
    

    @Override
    public void agregarLike(LikeDTO like){
        try {
            likeDAO.agregar(mapper.convertirAEntity(like));
            JOptionPane.showMessageDialog(null,"Like enviado con exito","Exito", JOptionPane.OK_OPTION);
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null,"Like no fue enviado con exito","Error", JOptionPane.OK_OPTION);
            
        }
    }

    @Override
    public void eliminarLike(long id) {
        try {
            likeDAO.eliminar(id);
            JOptionPane.showMessageDialog(null,"Like eliminado con exito","Exito", JOptionPane.OK_OPTION);
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null,"Like no fue eliminado","Error", JOptionPane.OK_OPTION);
        }
    }
}
