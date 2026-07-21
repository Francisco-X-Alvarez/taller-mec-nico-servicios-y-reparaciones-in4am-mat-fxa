/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.franciscoalvarez.system;

import com.franciscoalvarez.controller.SceneManagerController;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Francisco Franco
 */
public class Principal extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage escenarioRaiz) {
        escenarioRaiz.setTitle("Taller Mecánico - Control de Servicios");
        
        //Inhabilitaa el cuadro de maximizar la ventana
        escenarioRaiz.setResizable(false);
        
        //Insertamos el icono para la ventana
        escenarioRaiz.getIcons().add(new Image(getClass().getResourceAsStream("/com/franciscoalvarez/styles/icono.png")));

        SceneManagerController.getInstanciaSceneManagerController().setEscenarioPrincipal(escenarioRaiz);
        SceneManagerController.getInstanciaSceneManagerController().vistaPrincipal();
    }
}
