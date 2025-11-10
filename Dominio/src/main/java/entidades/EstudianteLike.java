/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
@Entity
public class EstudianteLike implements Serializable{
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "id_Estudiante")
    private Estudiante estudiante;
    @ManyToOne()
    @JoinColumn(name = "id_like")
    private Likes like;

    public EstudianteLike() {
    }

    public EstudianteLike(Long id, Estudiante estudiante, Likes like) {
        this.id = id;
        this.estudiante = estudiante;
        this.like = like;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Likes getLike() {
        return like;
    }

    public void setLike(Likes like) {
        this.like = like;
    }

    @Override
    public String toString() {
        return "EstudianteLike{" + "id=" + id + ", estudiante=" + estudiante + ", like=" + like + '}';
    }
    
    
    
    
}
