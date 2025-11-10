package DTOs;

import DTOs.EstudianteDTO;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * 
 * @author brand
 */
public class LikeDTO {

    private Long id;
    private EstudianteDTO estudianteOrigen;
    private EstudianteDTO estudianteDestino;
    private Instant fechaHora;

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

    public Instant getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Instant fechaHora) {
        this.fechaHora = fechaHora;
        
    }

    @Override
    public String toString() {
        return "LikeDTO{" + "id=" + id + ", estudianteOrigen=" + estudianteOrigen + ", estudianteDestino=" + estudianteDestino + ", fechaHora=" + fechaHora + '}';
    }
}
