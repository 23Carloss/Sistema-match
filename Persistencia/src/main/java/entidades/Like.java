/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.time.LocalDateTime;

/**
 *
 * @author Sandra
 */
public class Like {
    private Long idLike;
    private Estudiante estudianteOrigen;
    private Estudiante estudianteDestino;
    private LocalDateTime fechaHora;

    public Like() {
    }

    public Like(Estudiante estudianteOrigen, Estudiante estudianteDestino) {
        this.estudianteOrigen = estudianteOrigen;
        this.estudianteDestino = estudianteDestino;
    }

    public Long getIdLike() {
        return idLike;
    }

    public void setIdLike(Long idLike) {
        this.idLike = idLike;
    }

    public Estudiante getEstudianteOrigen() {
        return estudianteOrigen;
    }

    public void setEstudianteOrigen(Estudiante estudianteOrigen) {
        this.estudianteOrigen = estudianteOrigen;
    }

    public Estudiante getEstudianteDestino() {
        return estudianteDestino;
    }

    public void setEstudianteDestino(Estudiante estudianteDestino) {
        this.estudianteDestino = estudianteDestino;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }
    
    
    
    
}

