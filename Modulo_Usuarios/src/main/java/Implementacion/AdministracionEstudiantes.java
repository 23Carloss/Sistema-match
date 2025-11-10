/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Implementacion;

import BO.EstudianteBO;
import BO.EstudianteLikeBO;
import BO.LikeBO;
import BO.PostBO;
import DTOs.EstudianteDTO;
import DTOs.EstudianteLikeDTO;
import DTOs.LikeDTO;
import DTOs.PostDTO;
import Interfaces.IEstudianteBO;
import Interfaces.IEstudianteLikeBO;
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
    private IEstudianteLikeBO estudianteLikeBO;
    private EstudianteDTO estudiante;
    private EstudianteDTO estudianteLikeado;
    private LikeDTO like;
    private PostDTO post;
    private EstudianteLikeDTO estudianteLike;
    
    
    public AdministracionEstudiantes(){
        estudianteBO = new EstudianteBO();
        postBO = new PostBO();
        likeBO = new LikeBO();
        estudianteLikeBO = new EstudianteLikeBO();
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
//       System.out.println("Estudinte q lleg  modulo "  + estudiante.toString());
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
//       System.out.println("estudiante en parametro en moduloEstudiante:  " + estudiante.toString());
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
       this.post = post;
       return postBO.actualizarReacciones(post);
   }
   public PostDTO getPost(){
       return this.post;  
   }
   public void setPost(PostDTO post){
       this.post = post;  
   }
   
   public boolean verificarReaccionEstudiante(PostDTO post, EstudianteDTO estudiante){
    
       return likeBO.verificarReaccionEstudiante(post, estudiante.getId());
   }
   
   public List<EstudianteDTO>buscarEstudiantePorNombre(String nombre){
       return estudianteBO.BuscarPorNombre(nombre);
   }
   
   public void guardarLike(LikeDTO like){
       this.like=likeBO.agregarLike(like);
   }
   public void eliminarLike(LikeDTO like){
       likeBO.eliminarLike(like.getId());
   }
   public void setLike(LikeDTO like){
       this.like = like;
   }
   public LikeDTO getLike(){
       return this.like;
   }
   public LikeDTO obtenerLike(PostDTO post, EstudianteDTO estudiante) {
        return likeBO.obtenerLike(post, estudiante); 
    }
   
   public void registrarEstudianteLike(EstudianteLikeDTO estudianteLike){
       this.estudianteLike= estudianteLikeBO.agregarEstudianteLike(estudianteLike);
   }
   public void eliminarEstudianteLike(EstudianteLikeDTO estudianteLike){
       System.out.println("Estudinte en modulo: eliminr: " + estudianteLike.toString());
       estudianteLikeBO.eliminarEstudianteLike(estudianteLike.getId());
   }
   public EstudianteLikeDTO getEstudianteLike(){
       return estudianteLikeBO.obtenerEstudianteLike(estudiante, estudianteLikeado);
   }
   public boolean verificarEstudianteLike(EstudianteDTO estudianteActual, EstudianteDTO origen){
       return estudianteLikeBO.existeEstudianteLike(estudianteActual, origen);
   }
           
   
   
    
}
