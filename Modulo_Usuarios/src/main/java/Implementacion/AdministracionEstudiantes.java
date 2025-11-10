/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Implementacion;

import BO.EstudianteBO;
import BO.LikeBO;
import BO.PostBO;
import DTOs.EstudianteDTO;
import DTOs.LikeDTO;
import DTOs.PostDTO;
import Interfaces.IEstudianteBO;
import Interfaces.ILikeBO;
import Interfaces.IPostBO;
import java.util.List;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class AdministracionEstudiantes {
    private IEstudianteBO estudianteBO;
    private IPostBO postBO;
    private ILikeBO likeBO;
    private EstudianteDTO estudiante;
    private EstudianteDTO estudianteLikeado;
    
    
    public AdministracionEstudiantes(){
        estudianteBO = new EstudianteBO();
        postBO = new PostBO();
        likeBO = new LikeBO();
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
   
   public void setEstudianteBuscado(EstudianteDTO estudiante){
       this.estudianteLikeado = estudiante;
       System.out.println("Estudinte q lleg  modulo "  + estudiante.toString());
   }
   public EstudianteDTO getEstudianteBuscado(){
       return this.estudianteLikeado;
   }
   
   public EstudianteDTO getEstudiante(){
       return this.estudiante;
   }
   
   public List<PostDTO> cargarPublicaciones(){
      return postBO.obtenerPostFeed();
       
   }
   public List<PostDTO> cargarPublicacionesEstudiante(EstudianteDTO estudiante){
       System.out.println("estudiante en parametro en moduloEstudiante:  " + estudiante.toString());
       return postBO.obtenerPostPorEstudiante(estudiante);
   }
   
   public void guardarPost(PostDTO post){
      postBO.agregarPost(post);
   }
   public void actualizarPost(PostDTO post){
      postBO.actualizarPost(post);
   }
   
   public void eliminarPost(PostDTO post){
        postBO.eliminarPost(post.getId());
   }
   
   public PostDTO actualizarReaccion(PostDTO post){
       return postBO.actualizarReacciones(post);
   }
   
   public boolean verificarReaccionEstudiante(PostDTO post, EstudianteDTO estudiante){
       System.out.println("Estudiante que llega a modulo:  " + estudiante.toString());
       return  postBO.verificarReaccionEstudiante(post, estudiante.getId());
   }
   
   public List<EstudianteDTO>buscarEstudiantePorNombre(String nombre){
       return estudianteBO.BuscarPorNombre(nombre);
   }
   
   public void guardarLike(LikeDTO like){
       likeBO.agregarLike(like);
   }
   public void eliminarLike(LikeDTO like){
       likeBO.eliminarLike(like.getId());
   }
           
   
   
    
}
