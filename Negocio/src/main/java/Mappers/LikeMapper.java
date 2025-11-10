
package Mappers;

import DTOs.LikeDTO;
import DTOs.EstudianteDTO;
import entidades.Likes;
import entidades.Estudiante;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class LikeMapper {
    
    private EstudianteMapper mapper;
    
    public LikeMapper() {
        mapper = new EstudianteMapper();
    }
    
    public LikeDTO convertirADto(Likes like){
        LikeDTO likedto = new  LikeDTO();
        EstudianteDTO estudianteOrigen = mapper.ConvertirADto(like.getEstudianteOrigen());
        EstudianteDTO estudianteLikeado = mapper.ConvertirADto(like.getEstudianteDestino());
        likedto.setEstudianteOrigen(estudianteOrigen);
        likedto.setEstudianteDestino(estudianteLikeado);
        likedto.setFechaHora(like.getFechaHora());
        likedto.setId(like.getIdLike());
        return likedto;
        
    }
    public Likes convertirAEntity(LikeDTO likedto){
        Likes likes = new  Likes();
        Estudiante estudianteOrigen = mapper.ConvertirAEntity(likedto.getEstudianteOrigen());
        Estudiante estudianteLikeado = mapper.ConvertirAEntity(likedto.getEstudianteDestino());
        likes.setEstudianteOrigen(estudianteOrigen);
        likes.setEstudianteDestino(estudianteLikeado);
        likes.setFechaHora(likedto.getFechaHora());
        likes.setIdLike(likedto.getId());
        return likes;
        
    }
    
}
