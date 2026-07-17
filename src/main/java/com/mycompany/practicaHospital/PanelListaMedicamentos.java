/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaHospital;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PanelListaMedicamentos extends JPanel {

    private final JPanel panelRenglones;
    private final List<PanelMedicamento> renglones;

    public PanelListaMedicamentos() {
        setLayout(new BorderLayout());
        renglones = new ArrayList<>();

        panelRenglones = new JPanel();
        panelRenglones.setLayout(new BoxLayout(panelRenglones, BoxLayout.Y_AXIS));

        JScrollPane scroll = new JScrollPane(panelRenglones);
        scroll.setPreferredSize(new Dimension(600, 200));

        JButton botonAgregar = new JButton("+ Agregar medicamento");
        botonAgregar.addActionListener(e -> agregarRenglon());

        add(scroll, BorderLayout.CENTER);
        add(botonAgregar, BorderLayout.SOUTH);

        agregarRenglon(); // arranca con un renglon vacio
    }

    private void agregarRenglon() {
        PanelMedicamento nuevo = new PanelMedicamento();
        nuevo.alQuitar(() -> quitarRenglon(nuevo));
        renglones.add(nuevo);
        panelRenglones.add(nuevo);
        panelRenglones.revalidate();
        panelRenglones.repaint();
    }

    private void quitarRenglon(PanelMedicamento panel) {
        if (renglones.size() <= 1) {
            return; // siempre debe quedar al menos uno
        }
        renglones.remove(panel);
        panelRenglones.remove(panel);
        panelRenglones.revalidate();
        panelRenglones.repaint();
    }

    // Regresa solo los medicamentos con datos capturados (ignora renglones vacios)
    public List<DetalleReceta> obtenerMedicamentos() {
        List<DetalleReceta> lista = new ArrayList<>();
        for (PanelMedicamento p : renglones) {
            if (p.estaCompleto()) {
                lista.add(p.obtenerDetalleReceta());
            }
        }
        return lista;
    }

    public void limpiar() {
        panelRenglones.removeAll();
        renglones.clear();
        agregarRenglon();
        panelRenglones.revalidate();
        panelRenglones.repaint();
    }
}
