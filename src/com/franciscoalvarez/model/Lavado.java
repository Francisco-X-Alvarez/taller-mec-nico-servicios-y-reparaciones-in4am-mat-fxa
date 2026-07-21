/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franciscoalvarez.model;

/**
 *
 * @author Francisco Franco
 */
public class Lavado extends Servicio {

    // Atributos de Lavado
    private String tipoVehiculo;

    // Constructor vacío por defecto
    public Lavado() {
        super();
    }

    // Constructor para mandar los datos a la clase padre y guardar el tipo de carro
    public Lavado(String idServicio, String descripcion, String tipoVehiculo) {
        super(idServicio, descripcion);
        this.tipoVehiculo = tipoVehiculo;
    }

    // Métodos Getters y Setters
    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    // Polimorfismo: acá se calcula el precio dependiendo de si es SUV o un carro normal
    @Override
    public double facturar() {
        if (tipoVehiculo != null && tipoVehiculo.equalsIgnoreCase("SUV")) {
            return 80.00;
        } else {
            return 50.00;
        }
    }

    // toString para que en el ComboBox y en la tabla no salga el código raro del objeto
    @Override
    public String toString() {
        return "Lavado";
    }
}
