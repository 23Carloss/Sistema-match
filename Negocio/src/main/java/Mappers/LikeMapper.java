package Mappers;

import DTOs.LikeDTO;
import DTOs.EstudianteDTO;
import entidades.Likes;
import entidades.Estudiante;
import java.util.ArrayList;
import java.util.List;

/**
 * @author brand
 */
public class LikeMapper {

    private final EstudianteMapper estudianteMapper;

    public LikeMapper() {
        this.estudianteMapper = new EstudianteMapper();
    }

    public LikeDTO convertirADto(Likes like) {
        LikeDTO dto = new LikeDTO();
        dto.setId(like.getIdLike());
        dto.setEstudianteOrigen(estudianteMapper.ConvertirADto(like.getEstudianteOrigen()));
        dto.setEstudianteDestino(estudianteMapper.ConvertirADto(like.getEstudianteDestino()));
        dto.setFechaHora(like.getFechaHora());
        return dto;
    }

    public Likes convertirAEntity(LikeDTO dto) {
        Likes like = new Likes();
        like.setIdLike(dto.getId());
        like.setEstudianteOrigen(estudianteMapper.ConvertirAEntity(dto.getEstudianteOrigen()));
        like.setEstudianteDestino(estudianteMapper.ConvertirAEntity(dto.getEstudianteDestino()));
        like.setFechaHora(dto.getFechaHora());
        return like;
    }

    public List<LikeDTO> convertirListaADto(List<Likes> listaEntity) {
        List<LikeDTO> listaDTO = new ArrayList<>();
        for (Likes like : listaEntity) {
            listaDTO.add(convertirADto(like));
        }
        return listaDTO;
    }
}
