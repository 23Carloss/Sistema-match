/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Aplicacion;

/**
 *
 * @author Sandra
 */
import DTOs.EstudianteDTO;
import Implementacion.AdministracionEstudiantes;
import Pantallas.CrearCuenta;
import Pantallas.FrmInicioSesion;
import Pantallas.FramePrincipal;
import Pantallas.CrearCuenta;
import Pantallas.Explorar;
import Pantallas.Matches;
import javax.swing.JFrame;

public class Control2 {

    //private AdministracionEstudiantes moduloEstudiantes;
    private FramePrincipal frame;
    private FrmInicioSesion frmInicioSesion;
    private CrearCuenta crearCuenta;
    private Explorar explorar;
    private Matches matches;

    public Control2() {
        frame = new FramePrincipal();
    }

    public void iniciar() {
        MostrarInicioSesion();
    }

    public void MostrarInicioSesion() {
        System.out.println("Inicio de sesion");
        frmInicioSesion = new FrmInicioSesion(this);
        CambiarPantalla(frmInicioSesion);
    }

    private void CambiarPantalla(JFrame nuevaPantalla) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(nuevaPantalla);
        frame.pack();
//        frame.revalidate();
//        frame.repaint();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public void MostrarCrearCuenta() {
        crearCuenta = new CrearCuenta(this);
        CambiarPantalla(crearCuenta);
    }

    public void MostrarExplorar() {
        explorar = new Explorar(this);
        CambiarPantalla(explorar);
    }


//    public boolean iniciarSesion(String correo, String contraenia) {
//        if (moduloEstudiantes.iniciarSesion(correo, contraenia) == null) {
//            return false;
//        } else {
//            moduloEstudiantes.iniciarSesion(correo, contraenia);
//            setEstudiante(moduloEstudiantes.iniciarSesion(correo, contraenia));
//            return true;
//        }
//
//    }

    public void agregarEstudiante(EstudianteDTO estudiante) {
        moduloEstudiantes.AgregarEstudiante(estudiante);
    }

    public void setEstudiante(EstudianteDTO estudiante) {
        moduloEstudiantes.setEstudiante(estudiante);
    }

    public EstudianteDTO getEstudiante() {
        return moduloEstudiantes.getEstudiante();
    }
}
