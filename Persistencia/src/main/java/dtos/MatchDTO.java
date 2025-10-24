package dtos;

import dtos.EstudianteDTO;
import java.time.LocalDateTime;

/**
 * 
 * @author brand
 */
public class MatchDTO {

    private Long id;
    private EstudianteDTO estudiante1;
    private EstudianteDTO estudiante2;
    private LocalDateTime fechaHoraMatch;

    public MatchDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EstudianteDTO getEstudiante1() {
        return estudiante1;
    }

    public void setEstudiante1(EstudianteDTO estudiante1) {
        this.estudiante1 = estudiante1;
    }

    public EstudianteDTO getEstudiante2() {
        return estudiante2;
    }

    public void setEstudiante2(EstudianteDTO estudiante2) {
        this.estudiante2 = estudiante2;
    }

    public LocalDateTime getFechaHoraMatch() {
        return fechaHoraMatch;
    }

    public void setFechaHoraMatch(LocalDateTime fechaHoraMatch) {
        this.fechaHoraMatch = fechaHoraMatch;
    }
}
