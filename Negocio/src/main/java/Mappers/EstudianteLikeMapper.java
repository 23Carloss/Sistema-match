package Mappers;

import DTOs.EstudianteLikeDTO;
import entidades.EstudianteLike;

/**
 *
 * @author brand
 */
public class EstudianteLikeMapper {

    private final EstudianteMapper estudianteMapper = new EstudianteMapper();

    public EstudianteLikeMapper() {
        
    }
 
    public EstudianteLikeDTO convertirADto(EstudianteLike entity) {
        EstudianteLikeDTO dto = new EstudianteLikeDTO();
        dto.setId(entity.getId());
        dto.setEstudianteOrigen(estudianteMapper.ConvertirADto(entity.getEstudianteOrigen()));
        dto.setEstudianteDestino(estudianteMapper.ConvertirADto(entity.getEstudianteDestino()));
        dto.setCreadoEn(entity.getCreadoEn());
        return dto;
    }

    public EstudianteLike convertirAEntity(EstudianteLikeDTO dto) {
        EstudianteLike entity = new EstudianteLike();
        entity.setId(dto.getId());
        entity.setEstudianteOrigen(estudianteMapper.ConvertirAEntity(dto.geteEstudianteOrigen()));
        entity.setEstudianteDestino(estudianteMapper.ConvertirAEntity(dto.getEstudianteDestino()));
        entity.setCreadoEn(dto.getCreadoEn());
        return entity;
    }
}
