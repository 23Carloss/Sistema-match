package Mappers;

import DTOs.MatchDTO;
import DTOs.EstudianteDTO;
import entidades.Matches;
import entidades.Estudiante;
import java.util.ArrayList;
import java.util.List;

/**
 * @author brand
 */
public class MatchMapper {

    private final EstudianteMapper estudianteMapper;

    public MatchMapper() {
        this.estudianteMapper = new EstudianteMapper();
    }

    public MatchDTO convertirADto(Matches match) {
        MatchDTO dto = new MatchDTO();
        dto.setId(match.getId());
        dto.setEstudiante1(estudianteMapper.ConvertirADto(match.getEstudiante1()));
        dto.setEstudiante2(estudianteMapper.ConvertirADto(match.getEstudiante2()));
        dto.setFechaHoraMatch(match.getFechaHoraMatch());
        return dto;
    }

    public Matches convertirAEntity(MatchDTO dto) {
        Matches match = new Matches();
        match.setId(dto.getId());
        match.setEstudiante1(estudianteMapper.ConvertirAEntity(dto.getEstudiante1()));
        match.setEstudiante2(estudianteMapper.ConvertirAEntity(dto.getEstudiante2()));
        match.setFechaHoraMatch(dto.getFechaHoraMatch());
        return match;
    }

    public List<MatchDTO> convertirListaADto(List<Matches> listaEntity) {
        List<MatchDTO> listaDTO = new ArrayList<>();
        for (Matches match : listaEntity) {
            listaDTO.add(convertirADto(match));
        }
        return listaDTO;
    }
}
