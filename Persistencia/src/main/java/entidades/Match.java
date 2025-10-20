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
public class Match {
    private Long idMatch;
    private Estudiante estudiante1;
    private Estudiante estudiante2;
    
    private LocalDateTime fechaHoraMatch;
    
   

    public Match() {
    }

    public Match(Estudiante estudiante1, Estudiante estudiante2) {
        this.estudiante1 = estudiante1;
        this.estudiante2 = estudiante2;
    }

    public Long getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(Long idMatch) {
        this.idMatch = idMatch;
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
