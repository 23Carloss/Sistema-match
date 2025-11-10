package DTOs;

/**
 * 
 * @author brand
 */
public class EstudianteLikeDTO {

    private Long id;
    private EstudianteDTO estudiante;
    private LikeDTO like;

    public EstudianteLikeDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EstudianteDTO getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteDTO estudiante) {
        this.estudiante = estudiante;
    }

    public LikeDTO getLike() {
        return like;
    }

    public void setLike(LikeDTO like) {
        this.like = like;
    }
}
