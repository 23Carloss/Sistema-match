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
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 *
 * @author Sandra
 */
@Entity
public class Likes implements Serializable {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "estudiante_origen_id")
    private Estudiante estudianteOrigen;
    @ManyToOne(optional = false)
    @JoinColumn(name = "estudiante_destino_id")
    private Estudiante estudianteDestino;
    
    
    private Instant fechaHora;
    
    @ManyToOne(optional = true)
    @JoinColumn(name = "post_id")
    private Post post;
//    @OneToMany(mappedBy= "like")
//    private List<EstudianteLike> likes;  
    
    public Likes() {
    }

    public Likes(Long id, Estudiante estudianteOrigen, Estudiante estudianteDestino, Instant fechaHora, List<EstudianteLike> likes) {
        this.id = id;
        this.estudianteOrigen = estudianteOrigen;
        this.estudianteDestino = estudianteDestino;
        this.fechaHora = fechaHora;

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

    public Instant getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Instant fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Likes{" + "id=" + id + ", estudianteOrigen=" + estudianteOrigen + ", estudianteDestino=" + estudianteDestino + ", fechaHora=" + fechaHora + ", post=" + post + '}';
    }
    
}

