package com.mycompany.practicas;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;


public class Practica4
{
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Formulario");
        ventana.setSize(700, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        
        JLabel nombre = new JLabel("nombres(s)");
        JTextField casilla1 = new JTextField(10);
        JLabel apellidoM = new JLabel("Apellido materno");
        JTextField casilla2 = new JTextField(10);
        JLabel apellidoP = new JLabel("Apellido paterno");
        JTextField casilla3 = new JTextField(10);
        
        JLabel fechaNacLabel = new JLabel("Fecha Nac. (dd/mm/yyyy):");
        JDateChooser casillaFechaNac = new JDateChooser();
        casillaFechaNac.setDateFormatString("dd/MM/yyyy"); 
        casillaFechaNac.setPreferredSize(new Dimension(120, 20)); 
        
        JLabel edadLabel = new JLabel("Edad:");
        JTextField casillaEdad = new JTextField(4);
        casillaEdad.setEditable(false);
        
        JButton boton = new JButton("Guardar");
        
        boton.addActionListener(e -> {
            
        });
        
        panel.add(nombre);
        panel.add(casilla1);
        panel.add(apellidoM);
        panel.add(casilla2);
        panel.add(apellidoP);
        panel.add(casilla3);
        panel.add(fechaNacLabel);
        panel.add(casillaFechaNac);
        panel.add(edadLabel);
        panel.add(casillaEdad);
        panel.add(boton);
        
        ventana.add(panel);
        ventana.setVisible(true);
    }
}