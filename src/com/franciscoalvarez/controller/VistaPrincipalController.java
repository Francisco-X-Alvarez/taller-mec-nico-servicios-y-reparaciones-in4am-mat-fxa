/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franciscoalvarez.controller;

import com.franciscoalvarez.view.VistaPrincipalView;
import com.franciscoalvarez.view.RegistroView;
import com.franciscoalvarez.view.ResumenView;

/**
 *
 * @author Francisco Franco
 */
public class VistaPrincipalController {

    // Contenedor de pestañas
    private final VistaPrincipalView vistaPrincipalView;

    // Constructor para enlazar la vista principal y mandar a llamar los subcontroladores
    public VistaPrincipalController(VistaPrincipalView vistaPrincipal) {
        this.vistaPrincipalView = vistaPrincipal;
        construirControladores();
        construirAcciones();
    }

    // Inicializar los controladores de cada pestaña para que manejen sus propios eventos
    public void construirControladores() {
        new RegistroController(RegistroView.getInstanciaRegistroView());
        new ResumenController(ResumenView.getInstanciaResumenView());
    }

    // Vincular los layouts y vistas independientes dentro de cada pestaña del TabPane principal
    public void construirAcciones() {
        this.vistaPrincipalView.getTabRegistro().setContent(
                RegistroView.getInstanciaRegistroView().getInstanciaPanel()
        );

        this.vistaPrincipalView.getTabResumen().setContent(
                ResumenView.getInstanciaResumenView().getInstanciaPanel()
        );
    }
}
