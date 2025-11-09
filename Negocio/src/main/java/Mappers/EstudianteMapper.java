/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Mappers;

import DTOs.EstudianteDTO;
import DTOs.PostDTO;
import entidades.Estudiante;
import entidades.Hobby;
import entidades.Post;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class EstudianteMapper {

    private PostMapper mapper;
    
    public EstudianteMapper() {
        mapper = new PostMapper();
    }
    
    public EstudianteDTO ConvertirADto(Estudiante estudiante){
        EstudianteDTO estudianteDTO= new EstudianteDTO();
        ArrayList<PostDTO> listaPostDTO = new ArrayList<>();
        estudianteDTO.setId(estudiante.getIdEstudiante());
        estudianteDTO.setNombre(estudiante.getNombre());
        estudianteDTO.setApellidoPaterno(estudiante.getApellidoPaterno());
        estudianteDTO.setApellidoMaterno(estudiante.getApellidoMaterno());
        estudianteDTO.setCorreo(estudiante.getCorreo());
        estudianteDTO.setContrasenia(estudiante.getContrasenia());
        estudianteDTO.setCarrera(estudiante.getCarrera());
        List<String> hobbies = estudiante.getHobby().stream()
            .map(Enum::name)
            .collect(Collectors.toList());
        estudianteDTO.setHobbies(hobbies);
        estudianteDTO.setLikesDados(estudiante.getLikesDados());
        estudianteDTO.setLikesRecibidos(estudiante.getLikesRecibidos());
        estudianteDTO.setMatches1(estudiante.getMatches1());
        estudianteDTO.setMatches2(estudiante.getMatches2());
        for(Post post:estudiante.getPublicaciones()) {
            listaPostDTO.add(mapper.convertirADto(post));
            
        }
        estudianteDTO.setListaPost(listaPostDTO);
        return estudianteDTO;
    }
    
    public Estudiante ConvertirAEntity(EstudianteDTO estudiante){
        Estudiante estudianteEntity = new Estudiante();
         ArrayList<Post> listaPost = new ArrayList<>();
        estudianteEntity.setIdEstudiante(estudiante.getId());
        estudianteEntity.setNombre(estudiante.getNombre());
        estudianteEntity.setApellidoPaterno(estudiante.getApellidoPaterno());
        estudianteEntity.setApellidoMaterno(estudiante.getApellidoMaterno());
        estudianteEntity.setCorreo(estudiante.getCorreo());
        estudianteEntity.setContrasenia(estudiante.getContrasenia());
        estudianteEntity.setCarrera(estudiante.getCarrera());
        List<Hobby> hobbies = estudiante.getHobbies().stream()
            .map(Hobby::fromString)
            .collect(Collectors.toList());
        for(PostDTO post:estudiante.getListaPost()) {
            listaPost.add(mapper.convertirAEntity(post));
        }
        estudianteEntity.setPublicaciones(listaPost);
        estudianteEntity.setHobby(hobbies);
        estudianteEntity.setLikesDados(estudiante.getLikesDados());
        estudianteEntity.setLikesRecibidos(estudiante.getLikesRecibidos());
        estudianteEntity.setMatches1(estudiante.getMatches1());
        estudianteEntity.setMatches2(estudiante.getMatches2());
        return estudianteEntity;
    }
    
    public List<EstudianteDTO> ConvertirListaADto(List<Estudiante> listaEntity){
        ArrayList<EstudianteDTO> listaEstudiante =  new  ArrayList<>();
        for(Estudiante estudiante :listaEntity){
            listaEstudiante.add(ConvertirADto(estudiante));
        }
        return listaEstudiante;
        
    
    }
}
