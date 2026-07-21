/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franciscoalvarez.view;

import javafx.scene.layout.Pane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Francisco Franco
 */
public class VistaPrincipalView {

    private static VistaPrincipalView instanciaVistaPrincipalView;
    private Pane instanciaPanel;

    // Contenedor de pestañas
    private TabPane seccionTabs;
    private Tab tabRegistro;
    private Tab tabResumen;
    private VBox cajaVertical;

    public VistaPrincipalView() {
        construirVista();
    }

    public void construirVista() {
        instanciaPanel = new Pane();
        cajaVertical = new VBox(15);
        seccionTabs = new TabPane();
        seccionTabs.setPrefWidth(680);
        seccionTabs.setPrefHeight(580); // Aseguramos que llene el alto

        tabRegistro = new Tab("Registro de Servicios");
        tabRegistro.setClosable(false);

        tabResumen = new Tab("Resumen de Facturación");
        tabResumen.setClosable(false);

        seccionTabs.getTabs().addAll(tabRegistro, tabResumen);
        cajaVertical.getChildren().add(seccionTabs);
        instanciaPanel.getChildren().add(cajaVertical);

        instanciaPanel.setStyle("-fx-background-color: transparent;");
        
        //Le asignamos la clase transparente a la caja vertical para que no tape el fondo
        cajaVertical.getStyleClass().add("vbox-transparente");

        //Dejamos que el TabPane use las fuentes y estilos configurados en tu archivo CSS
        seccionTabs.getStyleClass().add("tab-pane");
    }

    // Getters para que el SceneManager y los controladores puedan manipular los paneles y pestañas
    public Tab getTabRegistro() {
        return tabRegistro;
    }

    public Tab getTabResumen() {
        return tabResumen;
    }

    public Pane getInstanciaPanel() {
        return instanciaPanel;
    }

    // El Singleton de la vista principal para no estar creando ventanas a lo loco
    public static VistaPrincipalView getInstanciaVistaPrincipalView() {
        if (instanciaVistaPrincipalView == null) {
            instanciaVistaPrincipalView = new VistaPrincipalView();
        }
        return instanciaVistaPrincipalView;
    }
}
