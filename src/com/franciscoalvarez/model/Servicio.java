/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franciscoalvarez.model;

/**
 *
 * @author Francisco Franco
 */
public abstract class Servicio {

    // Atributos comunes heredados para todas las clases hijas
    private String idServicio;
    private String descripcion;

    // Constructor vacío por si se necesita crear la instancia vacía
    public Servicio() {
    }

    // Constructor con parámetros para heredar los datos principales del servicio
    public Servicio(String idServicio, String descripcion) {
        this.idServicio = idServicio;
        this.descripcion = descripcion;
    }

    // Métodos Getters y Setters para que las hijas y los controladores puedan leer y modificar los datos privados
    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Método abstracto obligatorio para que cada tipo de servicio haga su propia fórmula matemática
    public abstract double facturar();

    // toString abstracto para obligar a las clases hijas a devolver su propio nombre limpio
    @Override
    public abstract String toString();
}
