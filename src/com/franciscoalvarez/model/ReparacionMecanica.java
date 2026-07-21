/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franciscoalvarez.model;

/**
 *
 * @author Francisco Franco
 */
public class ReparacionMecanica extends Servicio {

    // Atributos de ReparacionMecanica
    private double costoRepuestos;
    private double horasManoObra;

    // Constructor vacío que hereda del padre
    public ReparacionMecanica() {
        super();
    }

    // Constructor con parámetros para setear el ID, la descripción y las variables de la reparación
    public ReparacionMecanica(String idServicio, String descripcion, double costoRepuestos, double horasManoObra) {
        super(idServicio, descripcion);
        this.costoRepuestos = costoRepuestos;
        this.horasManoObra = horasManoObra;
    }

    // Métodos Getters y Setters para poder acceder a los atributos privados desde el controlador
    public double getCostoRepuestos() {
        return costoRepuestos;
    }

    public void setCostoRepuestos(double costoRepuestos) {
        this.costoRepuestos = costoRepuestos;
    }

    public double getHorasManoObra() {
        return horasManoObra;
    }

    public void setHorasManoObra(double horasManoObra) {
        this.horasManoObra = horasManoObra;
    }

    // Polimorfismo: aquí se hace el cálculo sumando los repuestos y multiplicando las horas por Q150
    @Override
    public double facturar() {
        return this.costoRepuestos + (this.horasManoObra * 150.00);
    }

    // toString modificado con tilde para que se muestre bien bonito en la interfaz
    @Override
    public String toString() {
        return "Reparación Mecánica";
    }
}
