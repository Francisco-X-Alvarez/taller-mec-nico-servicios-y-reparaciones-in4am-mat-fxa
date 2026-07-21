/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franciscoalvarez.controller;

import com.franciscoalvarez.model.Servicio;
import com.franciscoalvarez.view.RegistroView;
import com.franciscoalvarez.view.ResumenView;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author Francisco Franco
 */
public class ResumenController {

    // Atributos de ResumenController
    private final ResumenView resumenView;
    private ObservableList<Servicio> listaObservableServicios;
    private static ResumenController instanciaReferencia;

    // Constructor para setear la vista y armar la tabla con sus datos de una vez
    public ResumenController(ResumenView resumenView) {
        this.resumenView = resumenView;
        instanciaReferencia = this;
        construirColumnas();
        construirDatos();
        construirAcciones();
    }

    // Método estático para que el otro controlador pueda llamar a esta misma instancia sin duplicarla
    public static ResumenController getInstanciaReferencia() {
        return instanciaReferencia;
    }

    // Configuración de las columnas del TableView usando las propiedades del modelo
    public void construirColumnas() {
        this.resumenView.getColId().setCellValueFactory(new PropertyValueFactory<>("idServicio"));

        // ASIGNACIÓN DE LA NUEVA COLUMNA: Lee dinámicamente el toString() del objeto hijo
        this.resumenView.getColTipo().setCellValueFactory(celda -> {
            if (celda.getValue() != null) {
                return new javafx.beans.property.SimpleStringProperty(celda.getValue().toString());
            }
            return new javafx.beans.property.SimpleStringProperty("");
        });

        this.resumenView.getColDescripcion().setCellValueFactory(new PropertyValueFactory<>("descripcion"));

        // Polimorfismo en la tabla: acá se jala el total facturado dinámicamente llamando a facturar()
        this.resumenView.getColTotal().setCellValueFactory(celda -> {
            if (celda.getValue() != null) {
                double total = celda.getValue().facturar();
                return new javafx.beans.property.SimpleDoubleProperty(total).asObject();
            }
            return new javafx.beans.property.SimpleDoubleProperty(0.0).asObject();
        });
    }

    // Jalar los registros que guardamos en el otro controlador y meterlos a la lista observable de la tabla
    public void construirDatos() {
        ArrayList<Servicio> lista = new RegistroController(RegistroView.getInstanciaRegistroView()).getListaRegistroServicios();
        listaObservableServicios = FXCollections.observableArrayList(lista);
        this.resumenView.getTblServicios().setItems(listaObservableServicios);
    }

    // Botones y eventos: acción para sumar todo lo facturado en el día usando un ciclo for
    public void construirAcciones() {
        this.resumenView.getBtnCalcularTotal().setOnAction((evento) -> {
            double acumuladoTotal = 0;
            for (Servicio s : listaObservableServicios) {
                acumuladoTotal += s.facturar();
            }
            JOptionPane.showMessageDialog(null, "El ingreso total acumulado del día es: Q." + acumuladoTotal);
        });
    }
}
