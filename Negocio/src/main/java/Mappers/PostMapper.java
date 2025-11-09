/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Mappers;

import DTOs.EstudianteDTO;
import DTOs.PostDTO;
import entidades.Estudiante;
import entidades.Post;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class PostMapper {

    public PostMapper() {
        
    }
    
    public PostDTO convertirADto(Post post){
        PostDTO postDto = new PostDTO();
        postDto.setMensaje(post.getMensaje());
        postDto.setCreadoEn(post.getCreadoEn());
        EstudianteDTO estudiante = new EstudianteDTO();
      
        estudiante.setId(post.getEstudiante().getIdEstudiante());
        estudiante.setNombre(post.getEstudiante().getNombre());
        estudiante.setApellidoPaterno(post.getEstudiante().getApellidoPaterno());
        estudiante.setApellidoPaterno(post.getEstudiante().getApellidoPaterno());
        postDto.setEstudiante(estudiante);
//        postDto.setLikeado(post.get); creo q no ocupo persistir si fue lakeado por el estudiante actual si 
        //  no sumarle la reaccion a menos de que queramos saber que estudiante le dio like
        postDto.setNumeroReacciones(post.getNumeroReacciones());
        postDto.setId(post.getId());
        return postDto;
    }
    public Post convertirAEntity(PostDTO post){
        Post postEntity = new Post();
        Estudiante estudiante = new Estudiante();
        postEntity.setId(post.getId());
        postEntity.setMensaje(post.getMensaje());
        postEntity.setCreadoEn(post.getCreadoEn());
        
        estudiante.setIdEstudiante(post.getEstudiante().getId());
        estudiante.setNombre(post.getEstudiante().getNombre());
        estudiante.setApellidoPaterno(post.getEstudiante().getApellidoPaterno());
        estudiante.setApellidoPaterno(post.getEstudiante().getApellidoPaterno());
        postEntity.setEstudiante(estudiante);
//        postDto.setLikeado(post.get); creo q no ocupo persistir si fue lakeado por el estudiante actual si 
        //  no sumarle la reaccion a menos de que queramos saber que estudiante le dio like
        postEntity.setNumeroReacciones(post.getNumeroReacciones());
        return postEntity;
    }
    
    public List<PostDTO> convertirLista(List<Post> listaPost){
        ArrayList<PostDTO> lista = new ArrayList<>();
        for(Post post: listaPost){
            lista.add(convertirADto(post));
        }
        return lista;
    }
    
}
