/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import DTOs.EstudianteDTO;
import DTOs.PostDTO;
import java.util.List;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public interface IPostBO {

    public void agregarPost(PostDTO post);

    public PostDTO actualizarPost(PostDTO post);

    public void eliminarPost(long id);

    public List<PostDTO> obtenerPostPorEstudiante(EstudianteDTO estudiante);

    public List<PostDTO> obtenerPostFeed();
    
    public PostDTO actualizarReacciones(PostDTO post);
    
    public boolean verificarReaccionEstudiante(PostDTO post, long idEstudiante);
}
