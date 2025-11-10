package DTOs;

import DTOs.EstudianteDTO;
import java.time.LocalDateTime;

/**
 * 
 * @author brand
 */
public class LikeDTO {

    private Long id;
    private EstudianteDTO estudianteOrigen;
    private EstudianteDTO estudianteDestino;
    private LocalDateTime fechaHora;

    public LikeDTO() {
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

    public EstudianteDTO getEstudianteDestino() {
        return estudianteDestino;
    }

    public void setEstudianteDestino(EstudianteDTO estudianteDestino) {
        this.estudianteDestino = estudianteDestino;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }
}
