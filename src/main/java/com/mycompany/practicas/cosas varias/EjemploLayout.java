package com.mycompany.practicas;

import javax.swing.*;
import java.awt.*;

public class EjemploLayout {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Ejemplo de Layout");
        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Cambiar el layout a FlowLayout
        ventana.setLayout(new FlowLayout());
        
        // Añadir componentes
        ventana.add(new JButton("Botón 1"));
        ventana.add(new JButton("Botón 2"));
        ventana.add(new JButton("Botón 3"));
        
        ventana.setVisible(true);
    }
}