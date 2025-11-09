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
import java.time.Instant;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Long id;
    @Column
    private String mensaje;
    @Column
    private Instant creadoEn;
    @Column
    private int numeroReacciones;
    
    
    //relacion 1 : M
    @ManyToOne()
    @JoinColumn(name = "id_Estudiante")
    private Estudiante estudiante;

    public Post() {
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

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", mensaje=" + mensaje + ", creadoEn=" + creadoEn + ", numeroReacciones=" + numeroReacciones + ", estudiante=" + estudiante.getIdEstudiante()+ '}';
    }
    
    
    

}
