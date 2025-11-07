/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Mappers;

import DTOs.EstudianteDTO;
import entidades.Estudiante;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class EstudianteMapper {

    public EstudianteMapper() {
    }
    
    public EstudianteDTO ConvertirADto(Estudiante estudiante){
        EstudianteDTO estudianteDTO= new EstudianteDTO();
        estudianteDTO.setNombre(estudiante.getNombre());
        estudianteDTO.setApellidoPaterno(estudiante.getApellidoPaterno());
        estudianteDTO.setApellidoMaterno(estudiante.getApellidoMaterno());
        estudianteDTO.setCorreo(estudiante.getCorreo());
        estudianteDTO.setContrasenia(estudiante.getContrasenia());
        estudianteDTO.setCarrera(estudiante.getCarrera());
//        estudianteDTO.setHobbies(estudiante.getHobby()); cambiar el tipo de dato en Dominio (a list en ves de Set) lo mismo abajo
        estudianteDTO.setLikesDados(estudiante.getLikesDados());
//        estudianteDTO.setLikesRecibidos(estudiante.getLikesRecibidos());
        estudianteDTO.setMatches1(estudiante.getMatches1());
        estudianteDTO.setMatches2(estudiante.getMatches2());
        
        return estudianteDTO;
    }
    
    public Estudiante ConvertirAEntity(EstudianteDTO estudiante){
        Estudiante estudianteEntity = new Estudiante();
        estudianteEntity.setNombre(estudiante.getNombre());
        estudianteEntity.setApellidoPaterno(estudiante.getApellidoPaterno());
        estudianteEntity.setApellidoMaterno(estudiante.getApellidoMaterno());
        estudianteEntity.setCorreo(estudiante.getCorreo());
        estudianteEntity.setContrasenia(estudiante.getContrasenia());
        estudianteEntity.setCarrera(estudiante.getCarrera());
//        estudianteEntity.setHobbies(estudiante.getHobby()); cambiar el tipo de dato en Dominio (a list en ves de Set) lo mismo abajo
        estudianteEntity.setLikesDados(estudiante.getLikesDados());
//        estudianteEntity.setLikesRecibidos(estudiante.getLikesRecibidos());
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
