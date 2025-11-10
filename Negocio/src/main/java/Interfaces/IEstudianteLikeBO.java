/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.EstudianteDTO;
import DTOs.EstudianteLikeDTO;

/**
 *
 * @author HP
 */
public interface IEstudianteLikeBO {
    public EstudianteLikeDTO agregarEstudianteLike(EstudianteLikeDTO estudianteLike);
    public void eliminarEstudianteLike(long id);
    public boolean existeEstudianteLike(EstudianteDTO origen, EstudianteDTO destino);
}
