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
import java.time.Instant;
import java.time.LocalDateTime;


/**
 *
 * @author Sandra
 */
@Entity
public class Matches implements Serializable{
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    @Column
    private Estudiante estudianteOrigen;
    @Column
    private Estudiante estudianteLikeado;
    @Column
    private Instant fechaHoraMatch;

    public Matches() {
        
    }

    public Matches(Estudiante estudiante1, Estudiante estudiante2) {
        this.estudianteOrigen = estudiante1;
        this.estudianteLikeado = estudiante2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estudiante getEstudianteOrigen() {
        return estudianteOrigen;
    }

    public void setEstudianteOrigen(Estudiante estudianteOrigen) {
        this.estudianteOrigen = estudianteOrigen;
    }

    public Estudiante getEstudianteLikeado() {
        return estudianteLikeado;
    }

    public void setEstudianteLikeado(Estudiante estudianteLikeado) {
        this.estudianteLikeado = estudianteLikeado;
    }

    public Instant getFechaHoraMatch() {
        return fechaHoraMatch;
    }

    public void setFechaHoraMatch(Instant fechaHoraMatch) {
        this.fechaHoraMatch = fechaHoraMatch;
    }  
    
    
}
