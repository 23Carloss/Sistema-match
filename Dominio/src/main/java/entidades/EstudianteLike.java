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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.time.Instant;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
@Entity
public class EstudianteLike implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "id_EstudianteOrigen")
    private Estudiante estudianteOrigen;
    @ManyToOne()
    @JoinColumn(name = "id_EstudianteDestino")
    private Estudiante estudianteDestino;
    @Column
    private Instant creadoEn;

    public EstudianteLike() {
    }

    public EstudianteLike(Long id, Estudiante estudianteOrigen, Estudiante estudianteDestino) {
        this.id = id;
        this.estudianteOrigen = estudianteOrigen;
        this.estudianteDestino = estudianteDestino;
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

    public Estudiante getEstudianteDestino() {
        return estudianteDestino;
    }

    public void setEstudianteDestino(Estudiante estudianteDestino) {
        this.estudianteDestino = estudianteDestino;
    }

    public Instant getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(Instant creadoEn) {
        this.creadoEn = creadoEn;
    }

    @Override
    public String toString() {
        return "EstudianteLike{" + "id=" + id + ", estudianteOrigen=" + estudianteOrigen + ", estudianteDestino=" + estudianteDestino + ", creadoEn=" + creadoEn + '}';
    }

   

    

}
