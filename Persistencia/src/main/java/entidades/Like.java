/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Sandra
 */
@Entity
public class Like implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    @Column
    private Estudiante estudianteOrigen;
    @Column
    private Estudiante estudianteDestino;
    @Column
    private LocalDateTime fechaHora;

    public Like() {
    }

    public Like(Estudiante estudianteOrigen, Estudiante estudianteDestino) {
        this.estudianteOrigen = estudianteOrigen;
        this.estudianteDestino = estudianteDestino;
    }

    public Long getIdLike() {
        return id;
    }

    public void setIdLike(Long idLike) {
        this.id = idLike;
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

