/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hospital;

import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.io.*;

/**
 *
 * @author melan
 */
public class Hospital {

    public static void main(String[] args) {
 
        // Aplicar Look & Feel Nimbus (opcional, pero se ve mejor)
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info :
                    javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            // Si Nimbus no está disponible, usa el look por defecto — no es error crítico
            System.out.println("Nimbus no disponible, se usará el look por defecto.");
        }
 
        // Lanzar la interfaz en el hilo de eventos de Swing (buena práctica)
        java.awt.EventQueue.invokeLater(() -> {
            Controlador controlador = new Controlador();  // lógica de negocio
            Vista vista = new Vista(controlador);          // interfaz gráfica
            vista.setVisible(true);
        });
    }
}
    



