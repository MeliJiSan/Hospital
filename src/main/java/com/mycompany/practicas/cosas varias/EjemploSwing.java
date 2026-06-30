package com.mycompany.practicas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EjemploSwing {
    public static void main(String[] args) {
        // 1. Crear el marco (ventana)
        JFrame frame = new JFrame("Mi primera ventana");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 2. Crear un panel y un botón
        JPanel panel = new JPanel();
        JLabel etiqueta = new JLabel("Hola, mundo desde Swing!");
        JButton boton = new JButton("Haz clic");
        
        // 3. Añadir los componentes al panel
        panel.add(etiqueta);
        panel.add(boton);
        
        // 4. Añadir el panel a la ventana y hacerla visible    
        frame.add(panel);
        frame.setVisible(true);
    }
}