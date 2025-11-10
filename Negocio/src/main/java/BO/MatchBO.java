/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package BO;

import ConexionDB.conexionDB;
import DTOs.MatchDTO;
import Interfaces.IMatchBO;
import Mappers.MatchMapper;
import daos.MatchDAO;
import exception.PersistenciaException;
import interfaces.IMatchDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class MatchBO implements IMatchBO{

    private final IMatchDAO matchDAO;
    private MatchMapper mapper;
    
    public MatchBO() {
        this.matchDAO = new MatchDAO(conexionDB.getEntityManager());
    }

    @Override
    public void agregarMatch(MatchDTO match) {
        try {
            matchDAO.agregar(mapper.convertirAEntity(match));
            JOptionPane.showMessageDialog(null,"Match enviado con exito","Exito", JOptionPane.OK_OPTION);
        } catch (PersistenciaException ex) {
            Logger.getLogger(MatchBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
