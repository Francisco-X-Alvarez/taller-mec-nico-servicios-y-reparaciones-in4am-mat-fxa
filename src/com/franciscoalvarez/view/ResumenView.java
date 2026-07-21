/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franciscoalvarez.view;

import com.franciscoalvarez.model.Servicio;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Francisco Franco
 */
public class ResumenView {

    private static ResumenView instanciaResumenView;
    private Pane instanciaPanel;
    private VBox contenedor;
    private TableView<Servicio> tblServicios;
    private TableColumn<Servicio, String> colId;
    private TableColumn<Servicio, String> colTipo;
    private TableColumn<Servicio, String> colDescripcion;
    private TableColumn<Servicio, Double> colTotal;

    // Botones
    private Button btnCalcularTotal;

    private ResumenView() {
        construirVista();
    }

    public void construirVista() {
        instanciaPanel = new Pane();
        contenedor = new VBox(20);
        contenedor.setPadding(new Insets(20));

        // Permite que el contenedor sea transparente y muestre el fondo del carro
        contenedor.getStyleClass().add("vbox-transparente");

        tblServicios = new TableView<>();
        tblServicios.setPrefWidth(640);
        tblServicios.setPrefHeight(420);

        colId = new TableColumn<>("ID Servicio");
        colId.setPrefWidth(90);

        colTipo = new TableColumn<>("Tipo de Servicio");
        colTipo.setPrefWidth(140);

        colDescripcion = new TableColumn<>("Descripción");
        colDescripcion.setPrefWidth(260);

        colTotal = new TableColumn<>("Total Facturado (Q)");
        colTotal.setPrefWidth(140);

        tblServicios.getColumns().addAll(colId, colTipo, colDescripcion, colTotal);
        btnCalcularTotal = new Button("Calcular Total de Ingresos");

        contenedor.getChildren().addAll(tblServicios, btnCalcularTotal);
        instanciaPanel.getChildren().add(contenedor);

        javafx.scene.layout.AnchorPane.setTopAnchor(contenedor, 0.0);
        javafx.scene.layout.AnchorPane.setBottomAnchor(contenedor, 0.0);
        javafx.scene.layout.AnchorPane.setLeftAnchor(contenedor, 0.0);
        javafx.scene.layout.AnchorPane.setRightAnchor(contenedor, 0.0);
    }

    public static ResumenView getInstanciaResumenView() {
        if (instanciaResumenView == null) {
            instanciaResumenView = new ResumenView();
        }
        return instanciaResumenView;
    }

    public Pane getInstanciaPanel() {
        return instanciaPanel;
    }

    public TableView<Servicio> getTblServicios() {
        return tblServicios;
    }

    public TableColumn<Servicio, String> getColId() {
        return colId;
    }

    public TableColumn<Servicio, String> getColTipo() {
        return colTipo;
    }

    public TableColumn<Servicio, String> getColDescripcion() {
        return colDescripcion;
    }

    public TableColumn<Servicio, Double> getColTotal() {
        return colTotal;
    }

    public Button getBtnCalcularTotal() {
        return btnCalcularTotal;
    }
}
