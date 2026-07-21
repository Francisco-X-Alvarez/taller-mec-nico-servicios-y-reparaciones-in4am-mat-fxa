/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franciscoalvarez.view;

import javafx.scene.layout.Pane;
import javafx.scene.control.ComboBox;
import com.franciscoalvarez.model.Servicio;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author Francisco Franco
 */
public class RegistroView {

    private static RegistroView instanciaRegistroView;
    private Pane instanciaPanel;
    private Label lblTipoServicio;
    private ComboBox<Servicio> cmbTipoServicio;
    private VBox cajaVertical;
    private GridPane formulario;

    // Atributos de Estudiante
    private Label lblIdServicio;
    private Label lblDescripcion;
    private TextField txtIdServicio;
    private TextField txtDescripcion;

    private Label lblTipoVehiculo;
    private TextField txtTipoVehiculo;

    private Label lblCostoRepuestos;
    private Label lblHorasManoObra;
    private TextField txtCostoRepuestos;
    private TextField txtHorasManoObra;

    private Label lblNumeroEjes;
    private TextField txtNumeroEjes;

    // Botones
    private Button btnGuardar;

    private RegistroView() {
        construirVista();
    }

    public void construirVista() {
        instanciaPanel = new Pane();
        cajaVertical = new VBox(15);
        cajaVertical.setPadding(new Insets(15));

        //Habilita la transparencia para heredar correctamente la imagen de fondo
        cajaVertical.getStyleClass().add("vbox-transparente");

        lblTipoServicio = new Label("Seleccione el servicio automotriz:");
        cmbTipoServicio = new ComboBox<>();

        formulario = new GridPane();
        formulario.setVgap(10);
        formulario.setHgap(15);

        // Inicializamos los componentes de texto y labels
        lblIdServicio = new Label("ID Servicio:");
        txtIdServicio = new TextField();
        lblDescripcion = new Label("Descripción:");
        txtDescripcion = new TextField();

        lblTipoVehiculo = new Label("Tipo de Vehículo (Compacto/SUV):");
        txtTipoVehiculo = new TextField();

        lblCostoRepuestos = new Label("Costo de Repuestos:");
        txtCostoRepuestos = new TextField();
        lblHorasManoObra = new Label("Horas de Mano de Obra:");
        txtHorasManoObra = new TextField();

        lblNumeroEjes = new Label("Número de Ejes:");
        txtNumeroEjes = new TextField();

        btnGuardar = new Button("Guardar Registro");

        // AGREGAR LOS COMPONENTES AL GRIDPANE
        formulario.add(lblIdServicio, 0, 0);
        formulario.add(txtIdServicio, 1, 0);
        formulario.add(lblDescripcion, 0, 1);
        formulario.add(txtDescripcion, 1, 1);

        formulario.add(lblTipoVehiculo, 0, 2);
        formulario.add(txtTipoVehiculo, 1, 2);
        formulario.add(lblCostoRepuestos, 0, 3);
        formulario.add(txtCostoRepuestos, 1, 3);
        formulario.add(lblHorasManoObra, 0, 4);
        formulario.add(txtHorasManoObra, 1, 4);
        formulario.add(lblNumeroEjes, 0, 5);
        formulario.add(txtNumeroEjes, 1, 5);

        HBox contenedorBotones = new HBox(15);
        contenedorBotones.getChildren().add(btnGuardar);
        formulario.add(contenedorBotones, 1, 6);

        // Ocultar los dinámicos al iniciar
        lblTipoVehiculo.setVisible(false);
        txtTipoVehiculo.setVisible(false);
        lblCostoRepuestos.setVisible(false);
        txtCostoRepuestos.setVisible(false);
        lblHorasManoObra.setVisible(false);
        txtHorasManoObra.setVisible(false);
        lblNumeroEjes.setVisible(false);
        txtNumeroEjes.setVisible(false);

        cajaVertical.getChildren().addAll(lblTipoServicio, cmbTipoServicio, formulario);
        instanciaPanel.getChildren().add(cajaVertical);

        javafx.scene.layout.AnchorPane.setTopAnchor(cajaVertical, 0.0);
        javafx.scene.layout.AnchorPane.setBottomAnchor(cajaVertical, 0.0);
        javafx.scene.layout.AnchorPane.setLeftAnchor(cajaVertical, 0.0);
        javafx.scene.layout.AnchorPane.setRightAnchor(cajaVertical, 0.0);
    }

    public static RegistroView getInstanciaRegistroView() {
        if (instanciaRegistroView == null) {
            instanciaRegistroView = new RegistroView();
        }
        return instanciaRegistroView;
    }

    public Pane getInstanciaPanel() {
        return instanciaPanel;
    }

    public ComboBox<Servicio> getCmbTipoServicio() {
        return cmbTipoServicio;
    }

    public TextField getTxtIdServicio() {
        return txtIdServicio;
    }

    public TextField getTxtDescripcion() {
        return txtDescripcion;
    }

    public Label getLblTipoVehiculo() {
        return lblTipoVehiculo;
    }

    public TextField getTxtTipoVehiculo() {
        return txtTipoVehiculo;
    }

    public Label getLblCostoRepuestos() {
        return lblCostoRepuestos;
    }

    public TextField getTxtCostoRepuestos() {
        return txtCostoRepuestos;
    }

    public Label getLblHorasManoObra() {
        return lblHorasManoObra;
    }

    public TextField getTxtHorasManoObra() {
        return txtHorasManoObra;
    }

    public Label getLblNumeroEjes() {
        return lblNumeroEjes;
    }

    public TextField getTxtNumeroEjes() {
        return txtNumeroEjes;
    }

    public Button getBtnGuardar() {
        return btnGuardar;
    }
}
