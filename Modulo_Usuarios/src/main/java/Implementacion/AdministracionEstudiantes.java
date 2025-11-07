/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Implementacion;

import BO.EstudianteBO;
import ConexionDB.conexionDB;
import DTOs.EstudianteDTO;
import Interfaces.IEstudianteBO;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class AdministracionEstudiantes {
    private IEstudianteBO estudianteBO;
    private EstudianteDTO estudiante;
    
    
    public AdministracionEstudiantes(){
        estudianteBO = new EstudianteBO();
    }
    
    public void ActualizarEstudiante(EstudianteDTO estudiante){
        estudianteBO.ActualizarEstudiante(estudiante);
    }
    public void AgregarEstudiante(EstudianteDTO estudiante){
        estudianteBO.AgregarEstudiante(estudiante);
        System.out.println("Estudiante a registrar =  " + estudiante.toString());
    }
    
   public void EliminarEstudiante(Long id){
       estudianteBO.EliminarEstudiante(id);
   }
   public EstudianteDTO iniciarSesion(String correo, String contrasenia){
       this.estudiante = estudianteBO.autenticar(correo, contrasenia);
       return estudiante;
   }
   
   public void setEstudiante(EstudianteDTO estudiante){
       this.estudiante = estudiante;
   }
   
   public EstudianteDTO getEstudiante(){
       return this.estudiante;
   }
   
   
    
}
