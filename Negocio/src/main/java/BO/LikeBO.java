/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package BO;

import ConexionDB.conexionDB;
import DTOs.EstudianteDTO;
import DTOs.LikeDTO;
import DTOs.PostDTO;
import Interfaces.ILikeBO;
import Mappers.LikeMapper;
import Mappers.PostMapper;
import daos.LikeDAO;
import entidades.Likes;
import entidades.Post;
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
    private PostMapper postMapper;

    public LikeBO() {
        likeDAO = new LikeDAO(conexionDB.getEntityManager());
        mapper = new LikeMapper();
        postMapper =new PostMapper();
    }
    
    private boolean validarLike(LikeDTO like){
        if (like.getPost() == null || like.getPost().getId() == null || like.getPost().getId() <=0) {
            JOptionPane.showMessageDialog(null, "Se debe seleccionar un post v[alido", "Error al validar", JOptionPane.ERROR_MESSAGE);
        }
        if (like.getEstudianteDestino() == null || like.getEstudianteDestino().getId() == null || like.getEstudianteDestino().getId() <= 0) {
            JOptionPane.showMessageDialog(null, "Se debe seleccionar un estudiante v[alido", "Error al validar", JOptionPane.ERROR_MESSAGE);

        }
        if (like.getEstudianteOrigen()== null || like.getEstudianteOrigen().getId() == null || like.getEstudianteOrigen().getId() <= 0) {
            JOptionPane.showMessageDialog(null, "Se debe seleccionar un estudiante v[alido", "Error al validar", JOptionPane.ERROR_MESSAGE);
        }
        return true;
    }
    

    @Override
    public LikeDTO agregarLike(LikeDTO like){
        try {
            LikeDTO likeDto = mapper.convertirADto(likeDAO.agregar(mapper.convertirAEntity(like)));
//            JOptionPane.showMessageDialog(null,"Like enviado con exito","Exito", JOptionPane.OK_OPTION);
//            System.out.println("Like desde DAO :" + likeDto.toString());
            return likeDto;
            
            
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null,"Like no fue enviado con exito","Error", JOptionPane.OK_OPTION);
            return null;
        }
    }

    @Override
    public void eliminarLike(long id) {
        try {
            likeDAO.eliminar(id);
//            JOptionPane.showMessageDialog(null,"Like eliminado con exito","Exito", JOptionPane.OK_OPTION);
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null,"Like no fue eliminado","Error", JOptionPane.OK_OPTION);
        }
    }

    @Override
    public boolean verificarReaccionEstudiante(PostDTO post, long idEstudiante) {
        try {
            Post postEncontrdo = conexionDB.getEntityManager().find(Post.class, post.getId());
//            System.out.println("post encontrdo: " + postEncontrdo.toString());
//            System.out.println("id encontrdo: " + idEstudiante);
            return likeDAO.verificarReaccionEstudiante(postEncontrdo, idEstudiante);
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null,"Error al verificar like","Error", JOptionPane.OK_OPTION);
            return false;
        }
    }

    @Override
    public LikeDTO obtenerLike(PostDTO post, EstudianteDTO estudiante) {
        try {
            Likes like = likeDAO.buscarLike(post.getId(), estudiante.getId());
            return like != null ? mapper.convertirADto(like) : null;
        } catch (PersistenciaException e) {
            JOptionPane.showMessageDialog(null,"Error al obtener like","Error", JOptionPane.OK_OPTION);
            return null;
        }
    }
}
