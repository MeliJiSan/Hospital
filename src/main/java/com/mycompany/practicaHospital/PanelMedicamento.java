/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaHospital;

import javax.swing.*;
import java.awt.*;

public class PanelMedicamento extends JPanel {

    private final JTextField campoNombre;
    private final JTextField campoDosis;
    private final JTextField campoFrecuencia;
    private final JTextField campoVia;
    private final JTextField campoDuracion;
    private final JButton botonQuitar;

    public PanelMedicamento() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        setBorder(BorderFactory.createEtchedBorder());

        campoNombre = new JTextField(12);
        campoDosis = new JTextField(8);
        campoFrecuencia = new JTextField(8);
        campoVia = new JTextField(8);
        campoDuracion = new JTextField(8);
        botonQuitar = new JButton("Quitar");

        add(new JLabel("Medicamento:"));
        add(campoNombre);
        add(new JLabel("Dosis:"));
        add(campoDosis);
        add(new JLabel("Frecuencia:"));
        add(campoFrecuencia);
        add(new JLabel("Via:"));
        add(campoVia);
        add(new JLabel("Duracion:"));
        add(campoDuracion);
        add(botonQuitar);
    }

    public void alQuitar(Runnable accion) {
        botonQuitar.addActionListener(e -> accion.run());
    }

    public boolean estaCompleto() {
        return !campoNombre.getText().trim().isEmpty()
                && !campoDosis.getText().trim().isEmpty();
    }

    public DetalleReceta obtenerDetalleReceta() {
        return new DetalleReceta(
                campoNombre.getText().trim(),
                campoDosis.getText().trim(),
                campoFrecuencia.getText().trim(),
                campoVia.getText().trim(),
                campoDuracion.getText().trim()
        );
    }
}