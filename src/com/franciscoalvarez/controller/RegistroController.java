/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franciscoalvarez.controller;

import java.util.ArrayList;
import com.franciscoalvarez.model.Servicio;
import com.franciscoalvarez.model.Lavado;
import com.franciscoalvarez.model.ReparacionMecanica;
import com.franciscoalvarez.model.RevisionFrenos;
import com.franciscoalvarez.view.RegistroView;
import javafx.collections.FXCollections;
import javax.swing.JOptionPane;

/**
 *
 * @author Francisco Franco
 */
public class RegistroController {

    // Atributos de RegistroController
    private final RegistroView registroView;
    private ArrayList<Servicio> listaTiposServicio;
    private static final ArrayList<Servicio> listaRegistroServicios = new ArrayList<>();

    // Constructor para conectar la vista e inicializar todo de un solo
    public RegistroController(RegistroView registroView) {
        this.registroView = registroView;
        cargarDatos();
        construirComboBox();
        construirAcciones();
    }

    // Cargar los objetos en la lista temporal para el ComboBox
    public void cargarDatos() {
        listaTiposServicio = new ArrayList<>();
        listaTiposServicio.add(new Lavado());
        listaTiposServicio.add(new ReparacionMecanica());
        listaTiposServicio.add(new RevisionFrenos());
    }

    // Llenar el ComboBox usando FXCollections para que JavaFX lo entienda
    public void construirComboBox() {
        this.registroView.getCmbTipoServicio().setItems(
                FXCollections.observableArrayList(listaTiposServicio)
        );
    }

    // Botones y eventos: acá configuramos qué pasa cuando se interactúa con la interfaz
    public void construirAcciones() {
        this.registroView.getCmbTipoServicio().setOnAction((evento) -> {
            validarCampos(this.registroView.getCmbTipoServicio().getValue());
        });

        this.registroView.getBtnGuardar().setOnAction((evento) -> {
            guardarServicio();
        });
    }

    // Función principal para guardar el servicio capturando los datos de los TextField
    public void guardarServicio() {
        Servicio tipoSeleccionado = this.registroView.getCmbTipoServicio().getValue();
        if (tipoSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "TIENES QUE ELEGIR EL TIPO DE SERVICIO");
            return;
        }

        try {
            String id = this.registroView.getTxtIdServicio().getText();
            String desc = this.registroView.getTxtDescripcion().getText();

            // Uso de instanceof para saber qué tipo de objeto crear según la selección
            if (tipoSeleccionado instanceof Lavado) {
                Lavado nuevo = new Lavado(id, desc, this.registroView.getTxtTipoVehiculo().getText());
                listaRegistroServicios.add(nuevo);

            } else if (tipoSeleccionado instanceof ReparacionMecanica) {
                double repuestos = Double.parseDouble(this.registroView.getTxtCostoRepuestos().getText());
                double horas = Double.parseDouble(this.registroView.getTxtHorasManoObra().getText());
                ReparacionMecanica nuevo = new ReparacionMecanica(id, desc, repuestos, horas);
                listaRegistroServicios.add(nuevo);

            } else if (tipoSeleccionado instanceof RevisionFrenos) {
                int ejes = Integer.parseInt(this.registroView.getTxtNumeroEjes().getText());
                RevisionFrenos nuevo = new RevisionFrenos(id, desc, ejes);
                listaRegistroServicios.add(nuevo);
            }

            JOptionPane.showMessageDialog(null, "Servicio registrado exitosamente.");

            // Actualizar la tabla del resumen automáticamente si la otra vista ya existe
            if (ResumenController.getInstanciaReferencia() != null) {
                ResumenController.getInstanciaReferencia().construirDatos();
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Ingrese valores numéricos válidos en los campos correspondientes.");
        }
    }

    // Mostrar u ocultar componentes dinámicamente según el servicio elegido en el combo
    public void validarCampos(Servicio objetoSeleccionado) {
        if (objetoSeleccionado == null) {
            return;
        }

        String claseSeleccionada = objetoSeleccionado.toString();

        // Por defecto colocamos el setVisible en false para limpiar la pantalla
        this.registroView.getLblTipoVehiculo().setVisible(false);
        this.registroView.getTxtTipoVehiculo().setVisible(false);
        this.registroView.getLblCostoRepuestos().setVisible(false);
        this.registroView.getTxtCostoRepuestos().setVisible(false);
        this.registroView.getLblHorasManoObra().setVisible(false);
        this.registroView.getTxtHorasManoObra().setVisible(false);
        this.registroView.getLblNumeroEjes().setVisible(false);
        this.registroView.getTxtNumeroEjes().setVisible(false);

        // Activar campos específicos según la opción del cliente
        if (claseSeleccionada.equals("Lavado")) {
            this.registroView.getLblTipoVehiculo().setVisible(true);
            this.registroView.getTxtTipoVehiculo().setVisible(true);
        } else if (claseSeleccionada.equals("Reparación Mecánica")) {
            this.registroView.getLblCostoRepuestos().setVisible(true);
            this.registroView.getTxtCostoRepuestos().setVisible(true);
            this.registroView.getLblHorasManoObra().setVisible(true);
            this.registroView.getTxtHorasManoObra().setVisible(true);
        } else if (claseSeleccionada.equals("Revisión de Frenos")) {
            this.registroView.getLblNumeroEjes().setVisible(true);
            this.registroView.getTxtNumeroEjes().setVisible(true);
        }
    }

    // Getter para pasarle la lista acumulada de registros al ResumenController
    public ArrayList<Servicio> getListaRegistroServicios() {
        return listaRegistroServicios;
    }
}
