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
public class Matches implements Serializable{
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    @Column
    private Estudiante estudiante1;
    @Column
    private Estudiante estudiante2;
    @Column
    private LocalDateTime fechaHoraMatch;

    public Matches() {
        
    }

    public Matches(Estudiante estudiante1, Estudiante estudiante2) {
        this.estudiante1 = estudiante1;
        this.estudiante2 = estudiante2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estudiante getEstudiante1() {
        return estudiante1;
    }

    public void setEstudiante1(Estudiante estudiante1) {
        this.estudiante1 = estudiante1;
    }

    public Estudiante getEstudiante2() {
        return estudiante2;
    }

    public void setEstudiante2(Estudiante estudiante2) {
        this.estudiante2 = estudiante2;
    }

    public LocalDateTime getFechaHoraMatch() {
        return fechaHoraMatch;
    }

    public void setFechaHoraMatch(LocalDateTime fechaHoraMatch) {
        this.fechaHoraMatch = fechaHoraMatch;
    }  
    
    
}
