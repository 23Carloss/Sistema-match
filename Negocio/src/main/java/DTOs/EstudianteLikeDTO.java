package DTOs;

import java.time.Instant;

/**
 * 
 * @author brand
 */
public class EstudianteLikeDTO {

    private Long id;
    private EstudianteDTO estudianteOrigen;
    private EstudianteDTO estudianteDestino;
    private Instant creadoEn;
    
  

    public EstudianteLikeDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EstudianteDTO geteEstudianteOrigen() {
        return estudianteOrigen;
    }

    public void setEstudianteOrigen(EstudianteDTO estudiante) {
        this.estudianteOrigen = estudiante;
    }

    public EstudianteDTO getEstudianteDestino() {
        return estudianteDestino;
    }

    public void setEstudianteDestino(EstudianteDTO estudianteDestino) {
        this.estudianteDestino = estudianteDestino;
    }

    public Instant getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(Instant creadoEn) {
        this.creadoEn = creadoEn;
    }

    @Override
    public String toString() {
        return "EstudianteLikeDTO{" + "id=" + id + ", estudianteOrigen=" + estudianteOrigen + ", estudianteDestino=" + estudianteDestino + ", creadoEn=" + creadoEn + '}';
    }

   
    
    

    
}
