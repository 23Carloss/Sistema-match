
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
   
    private final EstudianteMapper mapper;

    public MatchMapper() {
        mapper = new EstudianteMapper();
    }


    public List<MatchDTO> convertirListaADto(List<Matches> listaEntity) {
        List<MatchDTO> listaDTO = new ArrayList<>();
        for (Matches match : listaEntity) {
            listaDTO.add(convertirADto(match));
        }
        return listaDTO;
    }

    public MatchDTO convertirADto(Matches match){
        EstudianteDTO estudianteOrigen = mapper.ConvertirADto(match.getEstudianteOrigen());
        EstudianteDTO estudianteLikeado = mapper.ConvertirADto(match.getEstudianteLikeado());
        
        MatchDTO matchDto = new MatchDTO();
        matchDto.setId(match.getId());
        matchDto.setEstudianteOrigen(estudianteOrigen);
        matchDto.setEstudianteLikeado(estudianteLikeado);
        matchDto.setFechaHoraMatch(match.getFechaHoraMatch());
        return matchDto;
    }
    public Matches convertirAEntity(MatchDTO matchdto){
        Estudiante estudianteOrigen = mapper.ConvertirAEntity(matchdto.getEstudianteOrigen());
        Estudiante estudianteLikeado = mapper.ConvertirAEntity(matchdto.getEstudianteLikeado());
        
        Matches match = new Matches();
        match.setId(matchdto.getId());
        match.setEstudianteOrigen(estudianteOrigen);
        match.setEstudianteLikeado(estudianteLikeado);
        match.setFechaHoraMatch(matchdto.getFechaHoraMatch());
        return match;
    }

}
