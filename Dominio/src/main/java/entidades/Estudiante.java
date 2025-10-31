/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sandra
 */
@Entity
public class Estudiante implements Serializable{

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String apellidoMaterno; 
    @Column
    private String apellidoPaterno;
    @Column
    private String correo;
    @Column
    private String constrasenia;
    @Column
    private String carrera;
    // relacion de likes
    @OneToMany(mappedBy= "estudiante")
    private List<EstudianteLike> EstudiantesLikeados;
    
    
    @ElementCollection(targetClass = Hobby.class)
    @CollectionTable(name = "hobbys_Estudiante", joinColumns = @JoinColumn(name= "idEstudiante"))
    @Enumerated(EnumType.STRING)
    @Column(name = "hobby")
    private List<Hobby> hobby;
    

private List<Likes> likesDados = new ArrayList<>();

private List<Likes> likesRecibidos = new ArrayList<>();

private List<Matches> matches1 = new ArrayList<>();

 private List<Matches> matches2 = new ArrayList<>();

    public Estudiante() {
    }

    
    public Estudiante(Long id, String nombre, String apellidoMaterno, String apellidoPaterno, String correo, String constrasenia, String carrera, List<EstudianteLike> EstudiantesLikeados, List<Hobby> hobby) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.correo = correo;
        this.constrasenia = constrasenia;
        this.carrera = carrera;
        this.EstudiantesLikeados = EstudiantesLikeados;
        this.hobby = hobby;
    }

    public Long getIdEstudiante() {
        return id;
    }

    public void setIdEstudiante(Long idEstudiante) {
        this.id = idEstudiante;
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

    public String getConstrasenia() {
        return constrasenia;
    }

    public void setConstrasenia(String constrasenia) {
        this.constrasenia = constrasenia;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public List<Hobby> getHobby() {
        return hobby;
    }

    public void setHobby(List<Hobby> hobby) {
        this.hobby = hobby;
    }

    public List getLikesDados() {
        return likesDados;
    }

    public void setLikesDados(List likesDados) {
        this.likesDados = likesDados;
    }

    public List getLikesRecibidos() {
        return likesRecibidos;
    }

    public void setLikesRecibidos(List likesRecibidos) {
        this.likesRecibidos = likesRecibidos;
    }

    public List getMatches1() {
        return matches1;
    }

    public void setMatches1(List matches1) {
        this.matches1 = matches1;
    }

    public List getMatches2() {
        return matches2;
    }

    public void setMatches2(List matches2) {
        this.matches2 = matches2;
    }
 
 
}
