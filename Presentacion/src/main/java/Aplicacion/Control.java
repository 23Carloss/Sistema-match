/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Aplicacion;

import DTOs.EstudianteDTO;
import DTOs.LikeDTO;
import DTOs.PostDTO;
import Implementacion.AdministracionEstudiantes;
import Vistas.BuscarEstudiante;
import Vistas.Post.CrearPost;
import Vistas.FeedPrincipal;
import Vistas.FramePrincipal;
import Vistas.Perfil.PanelEditarPerfil;
import Vistas.PanelLogIn;
import Vistas.Post.PanelPublicaciones;
import Vistas.PanelRegistroDatosPersonales;
import Vistas.PanelRegistroInfoGeneral;
import Vistas.Perfil.PanelEstudiante;
import Vistas.Perfil.PerfilUsuario;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class Control {
    
    private AdministracionEstudiantes moduloEstudiantes;
    private FramePrincipal frame;
    private PanelLogIn panellogIn;
    private PanelRegistroDatosPersonales panelDatosPersonales;
    private PanelRegistroInfoGeneral panelInfoGeneral;
//    private menuPrincipal menuPrincipal;
    
    private FeedPrincipal feedPrincipal;
    private PerfilUsuario panelPerfil;
    private PanelEditarPerfil editarPerfil;
    private CrearPost crearPost;
    private PanelPublicaciones publicacionesEstudiante;
    private BuscarEstudiante buscarEstudiante;
    private PanelEstudiante panelEstudiante;

    public Control() {
        frame = new FramePrincipal();
        
        //mpdulo estudiantes
        moduloEstudiantes = new AdministracionEstudiantes();
//        panellogIn = new PanelLogIn(this);
//        panelDatosPersonales = new PanelRegistroDatosPersonales(this);
//        panelInfoGeneral = new PanelRegistroInfoGeneral(this);
//        menuPrincipal = new menuPrincipal(this);
    }

    public void iniciar(){
        mostrarLogIn();
    }
    public void mostrarLogIn(){
        System.out.println("Panel login");
        panellogIn = new PanelLogIn(this);
        cambiarPantalla(panellogIn);
    }
    public void mostrarRegistroDatosPersonales(){
        panelDatosPersonales = new PanelRegistroDatosPersonales(this);
        cambiarPantalla(panelDatosPersonales);
    }
    public void mostrarRegistroInfoGeneral(){
        panelInfoGeneral = new PanelRegistroInfoGeneral(this);
        cambiarPantalla(panelInfoGeneral);
    }
    public void mostrarMenuPrincipal(){
        feedPrincipal = new FeedPrincipal(this);
        cambiarPantalla(feedPrincipal);
    }
    public void mostrarPerfil(){
        panelPerfil = new PerfilUsuario(this);
        cambiarPantalla(panelPerfil);
    }
    public void mostrarEditarPerfil(){
        editarPerfil = new PanelEditarPerfil(this);
        cambiarPantalla(editarPerfil);
    }
    public void mostrarCrearPublicaciones(){
        crearPost = new CrearPost(this);
        cambiarPantalla(crearPost);
    }
    public void mostrarPublicacionesEstudiante(){
        publicacionesEstudiante = new PanelPublicaciones(this);
        cambiarPantalla(publicacionesEstudiante); 
    }
    public void mostrarBuscarEstudiante(){
        buscarEstudiante = new BuscarEstudiante(this);
        cambiarPantalla(buscarEstudiante); 
    }
    public void mostrarPerfilEstudiante(){
        panelEstudiante = new PanelEstudiante(this, getEstudianteBuscado());
        cambiarPantalla(panelEstudiante); 
    }
    
    private void cambiarPantalla(JPanel nuevaPantalla) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(nuevaPantalla);
        frame.pack();
//        frame.revalidate();
//        frame.repaint();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public boolean iniciarSesion(String correo, String contraenia){
        if(moduloEstudiantes.iniciarSesion(correo, contraenia) == null){
            return false;
        }else{
            moduloEstudiantes.iniciarSesion(correo, contraenia);
            setEstudiante(moduloEstudiantes.iniciarSesion(correo, contraenia));
            return true;
        }
        
    }
    
    public void agregarEstudiante(EstudianteDTO estudiante){
        moduloEstudiantes.AgregarEstudiante(estudiante);
    }
    
    public void ActualizarEstudiante(EstudianteDTO estudiante){
        moduloEstudiantes.ActualizarEstudiante(estudiante);

    }
    
    public void setEstudiante(EstudianteDTO estudiante){
        moduloEstudiantes.setEstudiante(estudiante);
    }
    public void setEstudianteBuscado(EstudianteDTO estudiante){
        moduloEstudiantes.setEstudianteBuscado(estudiante);
    }
    public EstudianteDTO getEstudiante(){
        return moduloEstudiantes.getEstudiante();
    }
    public EstudianteDTO getEstudianteBuscado(){
        return moduloEstudiantes.getEstudianteBuscado();
    }
    
    public List<PostDTO> cargarPostFeed(){
       return moduloEstudiantes.cargarPublicaciones();
    }
    
    public List<PostDTO> cargarPostEstudiante(EstudianteDTO estudiante){
        return moduloEstudiantes.cargarPublicacionesEstudiante(estudiante);
    }
    
    public void publicarPost(PostDTO post){
        moduloEstudiantes.guardarPost(post);
    }
    public void actulizarPost(PostDTO post){
        moduloEstudiantes.actualizarPost(post);
    }
    public void eliminarPost(PostDTO post){
        moduloEstudiantes.eliminarPost(post);
    }
    public PostDTO actualizarReacciones(PostDTO post){
        return moduloEstudiantes.actualizarReaccion(post);
    }
    public boolean verificarLikeEstudiante(PostDTO post){
        return moduloEstudiantes.verificarReaccionEstudiante(post, getEstudiante());
    }       
    
    public List<EstudianteDTO> cargarEstudiantesPorNombre(String nombre){
        return moduloEstudiantes.buscarEstudiantePorNombre(nombre);
    }
    
    public void registrarLike(LikeDTO like){
        moduloEstudiantes.guardarLike(like);
    }
    public void eliminarLike(LikeDTO like){
        moduloEstudiantes.eliminarLike(like);
    }
    
    
    
}
