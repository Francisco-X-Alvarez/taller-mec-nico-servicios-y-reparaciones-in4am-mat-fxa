/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franciscoalvarez.model;

/**
 *
 * @author Francisco Franco
 */
public class RevisionFrenos extends Servicio {

    // Atributos de RevisionFrenos
    private int numeroEjes;

    // Constructor vacío por defecto
    public RevisionFrenos() {
        super();
    }

    // Constructor con parámetros para pasarle los datos al padre y setear el número de ejes
    public RevisionFrenos(String idServicio, String descripcion, int numeroEjes) {
        super(idServicio, descripcion);
        this.numeroEjes = numeroEjes;
    }

    // Métodos Getters y Setters para cumplir con el encapsulamiento de la hoja de trabajo
    public int getNumeroEjes() {
        return numeroEjes;
    }

    public void setNumeroEjes(int numeroEjes) {
        this.numeroEjes = numeroEjes;
    }

    // Polimorfismo: acá sobreescribimos la función para calcular el costo multiplicando los ejes por Q75
    @Override
    public double facturar() {
        return this.numeroEjes * 75.00;
    }

    // toString para que se muestre el texto limpio en las columnas de la tabla y en el combo
    @Override
    public String toString() {
        return "Revisión de Frenos";
    }
}
