/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.EstudianteDTO;
import entidades.Hobby;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IEstudianteBO {
    public void AgregarEstudiante(EstudianteDTO estudiante);
    public void ActualizarEstudiante(EstudianteDTO estudiante);
    public List<EstudianteDTO> BuscarPorNombre(String nombre);
    public List<EstudianteDTO> BuscarPorHobby(Hobby hobby);
    public List<EstudianteDTO> ObtenerTodos();
    public void EliminarEstudiante(Long id);
    public EstudianteDTO BuscarPorId(Long id);
    public EstudianteDTO autenticar(String correo, String contrasenia);
    
}
