/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franciscoalvarez.controller;

import com.franciscoalvarez.view.VistaPrincipalView;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;


/**
 *
 * @author Francisco Franco
 */
public class SceneManagerController {

    // Atributos de SceneManagerController
    private static SceneManagerController instanciaSceneManagerController;
    private Stage escenarioPrincipal;

    // Constructor vacío obligatorio para el patrón Singleton
    public SceneManagerController() {
    }

    // Patrón Singleton para controlar que solo exista un manejador de escenas en todo el programa
    public static SceneManagerController getInstanciaSceneManagerController() {
        if (instanciaSceneManagerController == null) {
            instanciaSceneManagerController = new SceneManagerController();
        }
        return instanciaSceneManagerController;
    }

    // Guardar el escenario original que viene del arranque en la clase Principal
    public void setEscenarioPrincipal(Stage escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }

    // Método general para hacer el cambio de ventanas de forma limpia pasándole el panel y el tamaño
    public void cambiarEscena(Pane panelView, int ancho, int alto) {
        try {
            Scene escenaPrincipal = new Scene(panelView, ancho, alto);

            //Conecta el CSS 
            escenaPrincipal.getStylesheets().add(getClass().getResource("/com/franciscoalvarez/styles/VentanaEstilos.css").toExternalForm());

            this.escenarioPrincipal.setScene(escenaPrincipal);
            this.escenarioPrincipal.sizeToScene();
            this.escenarioPrincipal.show();
        } catch (NullPointerException objetoNulo) {
            JOptionPane.showMessageDialog(null, "Objeto nulo en cambiar escena");
        }
    }

    // Levantar la ventana principal llamando al método de cambiar escena e inicializando su controlador
    public void vistaPrincipal() {
        try {
            VistaPrincipalView vistaPrincipal = VistaPrincipalView.getInstanciaVistaPrincipalView();
            cambiarEscena(vistaPrincipal.getInstanciaPanel(), 680, 580);
            new VistaPrincipalController(vistaPrincipal);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al levantar vista principal");
        }
    }
    
    
}
