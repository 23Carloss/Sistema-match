/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Implementacion;

import BO.EstudianteBO;
import BO.PostBO;
import DTOs.EstudianteDTO;
import DTOs.PostDTO;
import Interfaces.IEstudianteBO;
import Interfaces.IPostBO;
import java.util.List;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class AdministracionEstudiantes {
    private IEstudianteBO estudianteBO;
    private IPostBO postBO;
    private EstudianteDTO estudiante;
    
    
    public AdministracionEstudiantes(){
        estudianteBO = new EstudianteBO();
        postBO = new PostBO();
    }
    
    public void ActualizarEstudiante(EstudianteDTO estudiante){
        estudianteBO.ActualizarEstudiante(estudiante);
    }
    public void AgregarEstudiante(EstudianteDTO estudiante){
        estudianteBO.AgregarEstudiante(estudiante);
        setEstudiante(estudiante);
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
   
   public List<PostDTO> cargarPublicaciones(){
      return postBO.obtenerPostFeed();
       
   }
   public List<PostDTO> cargarPublicacionesEstudiante(EstudianteDTO estudiante){
       return estudianteBO.BuscarPorId(estudiante.getId()).getListaPost();
   }
   
   public void guardarPost(PostDTO post){
      postBO.agregarPost(post);
   }
   
    
}
