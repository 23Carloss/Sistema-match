package Mappers;

import DTOs.EstudianteLikeDTO;
import entidades.EstudianteLike;

/**
 *
 * @author brand
 */
public class EstudianteLikeMapper {

    private final EstudianteMapper estudianteMapper = new EstudianteMapper();
    private final LikeMapper likeMapper = new LikeMapper();

    public EstudianteLikeDTO convertirADto(EstudianteLike entity) {
        EstudianteLikeDTO dto = new EstudianteLikeDTO();
        dto.setId(entity.getId());
        dto.setEstudiante(estudianteMapper.ConvertirADto(entity.getEstudiante()));
        dto.setLike(likeMapper.convertirADto(entity.getLike()));
        return dto;
    }

    public EstudianteLike convertirAEntity(EstudianteLikeDTO dto) {
        EstudianteLike entity = new EstudianteLike();
        entity.setId(dto.getId());
        entity.setEstudiante(estudianteMapper.ConvertirAEntity(dto.getEstudiante()));
        entity.setLike(likeMapper.convertirAEntity(dto.getLike()));
        return entity;
    }
}
