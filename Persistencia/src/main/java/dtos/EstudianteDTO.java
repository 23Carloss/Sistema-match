package dtos;

import entidades.Hobby;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author brand
 */
public class EstudianteDTO {

    private Long id;
    private String nombre;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private String correo;
    private String contrasenia;
    private String carrera;
    private Set<Hobby> hobbies;
    private List<LikeDTO> likesDados;
    private List<LikeDTO> likesRecibidos;
    private List<MatchDTO> matches1;
    private List<MatchDTO> matches2;

    public EstudianteDTO() {
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Set<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public List<LikeDTO> getLikesDados() {
        return likesDados;
    }

    public void setLikesDados(List<LikeDTO> likesDados) {
        this.likesDados = likesDados;
    }

    public List<LikeDTO> getLikesRecibidos() {
        return likesRecibidos;
    }

    public void setLikesRecibidos(List<LikeDTO> likesRecibidos) {
        this.likesRecibidos = likesRecibidos;
    }

    public List<MatchDTO> getMatches1() {
        return matches1;
    }

    public void setMatches1(List<MatchDTO> matches1) {
        this.matches1 = matches1;
    }

    public List<MatchDTO> getMatches2() {
        return matches2;
    }

    public void setMatches2(List<MatchDTO> matches2) {
        this.matches2 = matches2;
    }
}
