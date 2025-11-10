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
import javax.swing.JOptionPane;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class PostBO implements IPostBO {

    private final IPostDAO postDAO;
    private PostMapper mapper;

    public PostBO() {
        this.postDAO = new PostDAO(conexionDB.getEntityManager());
        this.mapper = new PostMapper();
    }

    @Override
    public void agregarPost(PostDTO post) {
        try {
            if (post == null) {
                JOptionPane.showMessageDialog(null, "El post no puede ser nulo", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (post.getEstudiante() == null) {
                JOptionPane.showMessageDialog(null, "El post debe tener un estudiante asociado", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            postDAO.agregarPost(mapper.convertirAEntity(post));
            JOptionPane.showMessageDialog(null, "Post publicado con exito", "Exito", JOptionPane.OK_OPTION);
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null, "Error al publicar post", "Error", JOptionPane.OK_OPTION);
        }
    }

    @Override
    public PostDTO actualizarPost(PostDTO post) {
        try {
            if (post == null || post.getId() == null) {
                JOptionPane.showMessageDialog(null, "El post no existe", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            
            Post postActualizado = postDAO.actualizarPost(mapper.convertirAEntity(post));
            JOptionPane.showMessageDialog(null, "Post publicado con exito", "Exito", JOptionPane.OK_OPTION);

            return mapper.convertirADto(postActualizado);
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar post", "Error", JOptionPane.OK_OPTION);
            return null;
        }
    }

    @Override
    public List<PostDTO> obtenerPostPorEstudiante(EstudianteDTO estudiante) {
        try {
            if (estudiante == null || estudiante.getId() == null) {
                JOptionPane.showMessageDialog(null, "El estudiante no es válido", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }

            return mapper.convertirLista(postDAO.obtenerPostPorEstudiante(estudiante.getId()));
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener post del estudiante", "Error", JOptionPane.OK_OPTION);
            return null;
        }
    }

    @Override
    public List<PostDTO> obtenerPostFeed() {
        try {
            
            return mapper.convertirLista(postDAO.obtenerPostFeed());
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener post", "Error", JOptionPane.OK_OPTION);
            return null;
        }

    }

    @Override
    public void eliminarPost(long id) {
        try {
            if (id <= 0) {
                JOptionPane.showMessageDialog(null, "ID inválido", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            postDAO.eliminarPost(id);
            JOptionPane.showMessageDialog(null, "Post eliminado con exito", "Exito", JOptionPane.OK_OPTION);
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar post", "Error", JOptionPane.OK_OPTION);
        }
    }

    @Override
    public PostDTO actualizarReacciones(PostDTO post) {
        try {
            if (post == null || post.getId() == null) {
                JOptionPane.showMessageDialog(null, "El post no es válido", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            if (post.getNumeroReacciones() < 0) {
                JOptionPane.showMessageDialog(null, "El numero de reacciones debe ser positivo", "Erro", JOptionPane.ERROR_MESSAGE);
                return post;
            }

            PostDTO postDto = mapper.convertirADto(postDAO.actulizarReaccion(mapper.convertirAEntity(post)));
            return postDto;
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar post", "Error", JOptionPane.OK_OPTION);
            return null;
        }
    }

    @Override
    public boolean verificarReaccionEstudiante(PostDTO post, long idEstudiante) {
        try {
            if (post == null || post.getId() == null) {
                JOptionPane.showMessageDialog(null, "El post no existe", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            if (idEstudiante <= 0) {
                JOptionPane.showMessageDialog(null, "ID de estudiante inválido", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            return postDAO.verificarReaccionEstudiante(mapper.convertirAEntity(post), idEstudiante);
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(null, "Error al verififcar like", "Error", JOptionPane.OK_OPTION);
            return false;
        }
    }

}
