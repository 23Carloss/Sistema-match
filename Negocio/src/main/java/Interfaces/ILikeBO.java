/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.EstudianteDTO;
import DTOs.LikeDTO;
import DTOs.PostDTO;

/**
 *
 * @author HP
 */
public interface ILikeBO {
    public LikeDTO agregarLike(LikeDTO like);
    public void eliminarLike(long id);
    public boolean verificarReaccionEstudiante(PostDTO post, long idEstudiante);
    public LikeDTO obtenerLike(PostDTO post, EstudianteDTO estudiante);
       
    
}
