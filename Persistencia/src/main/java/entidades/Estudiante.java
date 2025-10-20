/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Sandra
 */
public class Estudiante {

    private Long idEstudiante;
    private String nombre, apellidoMaterno, apellidoPaterno;
    private String correo, constrasenia;
    private String carrera;


private Set<Hobby> hobby = new HashSet<>();

private List<Like> likesDados = new ArrayList<>();

private List<Like> likesRecibidos = new ArrayList<>();

private List<Match> matches1 = new ArrayList<>();

 private List<Match> matches2 = new ArrayList<>();

    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
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

    public Set<Hobby> getHobby() {
        return hobby;
    }

    public void setHobby(Set<Hobby> hobby) {
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
