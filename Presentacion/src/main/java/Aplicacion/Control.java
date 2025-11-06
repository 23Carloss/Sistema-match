/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Aplicacion;

import Vistas.FramePrincipal;
import Vistas.PanelLogIn;
import Vistas.PanelRegistroDatosPersonales;
import Vistas.PanelRegistroInfoGeneral;
import Vistas.PerfilUsuario;
import Vistas.menuPrincipal;
import javax.swing.JPanel;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class Control {

    private FramePrincipal frame;
    private PanelLogIn panellogIn;
    private PanelRegistroDatosPersonales panelDatosPersonales;
    private PanelRegistroInfoGeneral panelInfoGeneral;
    private menuPrincipal menuPrincipal;
    private PerfilUsuario panelPerfil;

    public Control() {
        frame = new FramePrincipal();
//        panellogIn = new PanelLogIn(this);
//        panelDatosPersonales = new PanelRegistroDatosPersonales(this);
//        panelInfoGeneral = new PanelRegistroInfoGeneral(this);
//        menuPrincipal = new menuPrincipal(this);
    }

    public void iniciar(){
        MostrarLogIn();
    }
    public void MostrarLogIn(){
        System.out.println("Panel login");
        panellogIn = new PanelLogIn(this);
        CambiarPantalla(panellogIn);
    }
    public void MostrarRegistroDatosPersonales(){
        panelDatosPersonales = new PanelRegistroDatosPersonales(this);
        CambiarPantalla(panelDatosPersonales);
    }
    public void MostrarRegistroInfoGeneral(){
        panelInfoGeneral = new PanelRegistroInfoGeneral(this);
        CambiarPantalla(panelInfoGeneral);
    }
    public void MostrarMenuPrincipal(){
        menuPrincipal = new menuPrincipal(this);
        CambiarPantalla(menuPrincipal);
    }
    public void MostrarPerfil(){
        panelPerfil = new PerfilUsuario(this);
        CambiarPantalla(panelPerfil);
    }
    
    private void CambiarPantalla(JPanel nuevaPantalla) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(nuevaPantalla);
        frame.pack();
//        frame.revalidate();
//        frame.repaint();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}
