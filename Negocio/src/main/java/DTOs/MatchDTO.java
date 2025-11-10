package DTOs;

import DTOs.EstudianteDTO;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * 
 * @author brand
 */
public class MatchDTO {

    private Long id;
    private EstudianteDTO estudianteOrigen;
    private EstudianteDTO estudianteLikeado;
    private Instant fechaHoraMatch;

    public MatchDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EstudianteDTO getEstudianteOrigen() {
        return estudianteOrigen;
    }

    public void setEstudianteOrigen(EstudianteDTO estudianteOrigen) {
        this.estudianteOrigen = estudianteOrigen;
    }

    public EstudianteDTO getEstudianteLikeado() {
        return estudianteLikeado;
    }

    public void setEstudianteLikeado(EstudianteDTO estudianteLikeado) {
        this.estudianteLikeado = estudianteLikeado;
    }

    public Instant getFechaHoraMatch() {
        return fechaHoraMatch;
    }

    public void setFechaHoraMatch(Instant fechaHoraMatch) {
        this.fechaHoraMatch = fechaHoraMatch;
    }
}
