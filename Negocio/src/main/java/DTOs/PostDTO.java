/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.time.Instant;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class PostDTO {

    private Long id;
    private String mensaje;
    private Instant creadoEn;
    private int numeroReacciones;
    private boolean likeado = false;
    private EstudianteDTO estudiante;

    public PostDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Instant getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(Instant creadoEn) {
        this.creadoEn = creadoEn;
    }

    public int getNumeroReacciones() {
        return numeroReacciones;
    }

    public void setNumeroReacciones(int numeroReacciones) {
        this.numeroReacciones = numeroReacciones;
    }

    public EstudianteDTO getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteDTO estudiante) {
        this.estudiante = estudiante;
    }

    public boolean isLikeado() {
        return likeado;
    }

    public void setLikeado(boolean likeado) {
        this.likeado = likeado;
    }

    @Override
    public String toString() {
        return "PostDTO{" + "id=" + id + ", mensaje=" + mensaje + ", creadoEn=" + creadoEn + ", numeroReacciones=" + numeroReacciones + ", likeado=" + likeado + ", estudiante=" + estudiante.getId() + '}';
    }

}
