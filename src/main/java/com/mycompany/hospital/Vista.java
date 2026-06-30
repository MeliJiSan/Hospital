/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/*ckage com.mycompany.hospital;
import javax.swing.*;
import com.toedter.calendar.JCalendar;
import java.awt.event.ActionListener;
import java.util.Date;*/

package com.mycompany.hospital;
 
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;
// import javax.swing.JTextField;

/**
 *
 * @author melan
 */
public class Vista extends javax.swing.JFrame {
    
    private static final Logger logger = Logger.getLogger(Vista.class.getName());
   /** private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Vista.class.getName());

    private JTextField jTextField1_nombre, jTextField1_apellidop, jTextField1_apellidom, jTextField2_peso, jTextField2_edad, jTextField2_buscar1;
    private JComboBox<String> jComboBox1_genero;
    private JTable jTable2_TablaPacientes;
    private JButton jButton1_GuardarFecha, jButton2_guardar1, jButton2_guardar2,jButton2_guardar3, jButton2_buscar1, jButton2_siguiente1, jButton2_siguiente2, jButton2_siguiente3; 
    private JCalendar jCalendar1_fechaNacimiento;*/
    /**
     * Creates new form Vista
     */
    
    private Controlador controlador;

    // TableRowSorter para ordenar/filtrar la tabla de pacientes (Tab 4)
    private TableRowSorter<DefaultTableModel> modeloOrdenado;
    
    public Vista(Controlador controlador) {
        this.controlador = controlador;
         initComponents();
    
    // Configurar el TableRowSorter para ordenar la tabla de búsqueda
        DefaultTableModel modelo = (DefaultTableModel) jTable2_TablaPacientes.getModel();
        modeloOrdenado = new TableRowSorter<>(modelo);
        jTable2_TablaPacientes.setRowSorter(modeloOrdenado);
 
        // Listener del JCalendar: al cambiar la fecha, actualiza el campo edad
        //jCalendar1_fechaNacimiento.getDayChooser().addPropertyChangeListener("day", evt -> {
          java.beans.PropertyChangeListener actualizarFechaNacimiento = evt -> {
            Date fechaSeleccionada = jCalendar1_fechaNacimiento.getDate();
            if (fechaSeleccionada != null) {
                /**int edadCalculada = calcularEdadDesde(fechaSeleccionada);
                jTextField2_edad.setText(String.valueOf(edadCalculada));*/
                SimpleDateFormat sdfCorto = new SimpleDateFormat("dd/MM/yy");
                jTextField2_fechaNac.setText(sdfCorto.format(fechaSeleccionada));
                
                int edadCalculada = calcularEdadDesde(fechaSeleccionada);
                jTextField2_edad.setText(String.valueOf(edadCalculada));
            }
        };
          jCalendar1_fechaNacimiento.getDayChooser().addPropertyChangeListener("day", actualizarFechaNacimiento);
        jCalendar1_fechaNacimiento.getMonthChooser().addPropertyChangeListener("month", actualizarFechaNacimiento);
        jCalendar1_fechaNacimiento.getYearChooser().addPropertyChangeListener("year", actualizarFechaNacimiento);
 
        // Inicializar con la fecha que el JCalendar trae seleccionada por defecto (hoy)
        actualizarFechaNacimiento.propertyChange(null);
        /**
        // Acciones de navegación entre pestañas (Tabs)
        jButton2_siguiente1.addActionListener(e -> jTabbedPane1.setSelectedIndex(1)); // ir a Tab 2 (Consulta)
        jButton2_siguiente2.addActionListener(e -> jTabbedPane1.setSelectedIndex(2)); // ir a Tab 3 (Egreso)
        jButton2_siguiente3.addActionListener(e -> jTabbedPane1.setSelectedIndex(3)); // ir a Tab 4 (Buscar)
 
        // Tab 4 · Búsqueda en tiempo real al escribir
        jTextField2_buscar1.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            
            
            /**
            public void keyReleased(java.awt.event.KeyEvent evt) {
                String criterio = jTextField2_buscar1.getText();
                controlador.filtrarTabla(modeloOrdenado, criterio);
            }
        });
        
        jButton2_buscar1.addActionListener(e -> {
            String criterio = jTextField2_buscar1.getText();
            controlador.buscarYMostrar(criterio);
        });*/
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jComboBox2 = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1_nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField1_apellidop = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField1_apellidom = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1_genero = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jCalendar1_fechaNacimiento = new com.toedter.calendar.JCalendar();
        jLabel6 = new javax.swing.JLabel();
        jTextField2_edad = new javax.swing.JTextField();
        jButton2_guardar1 = new javax.swing.JButton();
        jButton2_siguiente1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTextField2_peso = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jDateChooser1_FechaActual = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jTextField2_hora = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jButton1_GuardarFecha = new javax.swing.JButton();
        jScrollPane4_Observaciones1 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jTextField2_fechaNac = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1_Alergias = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2_Observaciones2 = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1_diagnostico = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jRadioButton1_salidaAlta = new javax.swing.JRadioButton();
        jRadioButton2_salidaBaja = new javax.swing.JRadioButton();
        jButton2_guardar2 = new javax.swing.JButton();
        jButton2_siguiente2 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2_guardar3 = new javax.swing.JButton();
        jButton2_siguiente3 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable2_TablaPacientes = new javax.swing.JTable();
        jTextField2_buscar1 = new javax.swing.JTextField();
        jButton2_buscar1 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextField1.setText("jTextField1");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingreso"));

        jLabel1.setText("Nombre:");

        jTextField1_nombre.addActionListener(this::jTextField1_nombreActionPerformed);

        jLabel2.setText("ApellidoP:");

        jLabel3.setText("ApellidoM:");

        jTextField1_apellidom.addActionListener(this::jTextField1_apellidomActionPerformed);

        jLabel4.setText("Genero:");

        jComboBox1_genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Femenino", "Masculino", "Otro", " " }));

        jLabel5.setText("Fecha Nacimiento:");

        jLabel6.setText("Edad:");

        jTextField2_edad.setEditable(false);

        jButton2_guardar1.setText("Guardar");
        jButton2_guardar1.addActionListener(this::jButton2_guardar1ActionPerformed);

        jButton2_siguiente1.setText("Siguiente>");
        jButton2_siguiente1.addActionListener(this::jButton2_siguiente1ActionPerformed);

        jLabel11.setText("Peso (kg):");

        jLabel12.setText("Fecha (DD/MM/YY): ");

        jDateChooser1_FechaActual.setDateFormatString("dd/MM/yy");

        jLabel13.setText("Hora:");

        jTextField2_hora.setEditable(false);
        jTextField2_hora.addActionListener(this::jTextField2_horaActionPerformed);

        jLabel14.setText("Observaciones:");

        jButton1_GuardarFecha.setText("Guardar fecha");
        jButton1_GuardarFecha.addActionListener(this::jButton1_GuardarFechaActionPerformed);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane4_Observaciones1.setViewportView(jTextArea2);

        jTextField2_fechaNac.setEditable(false);
        jTextField2_fechaNac.addActionListener(this::jTextField2_fechaNacActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jButton2_guardar1)
                        .addGap(115, 115, 115)
                        .addComponent(jButton2_siguiente1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField2_fechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(76, 76, 76)
                                        .addComponent(jButton1_GuardarFecha)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCalendar1_fechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1_apellidop)
                                    .addComponent(jTextField1_apellidom)
                                    .addComponent(jTextField1_nombre)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jComboBox1_genero, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addGap(13, 13, 13)
                                                    .addComponent(jTextField2_edad, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jTextField2_peso))))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel12)
                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jDateChooser1_FechaActual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jTextField2_hora))))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane4_Observaciones1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(718, 718, 718))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1_apellidop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1_apellidom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1_genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jCalendar1_fechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1_GuardarFecha)
                                .addGap(47, 47, 47))
                            .addComponent(jTextField2_fechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField2_edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField2_peso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jDateChooser1_FechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jTextField2_hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jScrollPane4_Observaciones1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2_siguiente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2_guardar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(208, 208, 208))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1078, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab1", jPanel1);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de sintomas (Consulta)"));

        jLabel7.setText("Alergias:");

        jTextArea1_Alergias.setColumns(20);
        jTextArea1_Alergias.setRows(5);
        jScrollPane1.setViewportView(jTextArea1_Alergias);

        jLabel8.setText("Observaciones:");

        jTextArea2_Observaciones2.setColumns(20);
        jTextArea2_Observaciones2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2_Observaciones2);

        jLabel9.setText("Diagnostico:");

        jTextArea1_diagnostico.setEditable(false);
        jTextArea1_diagnostico.setColumns(20);
        jTextArea1_diagnostico.setRows(5);
        jScrollPane3.setViewportView(jTextArea1_diagnostico);

        jLabel10.setText("Salida:");

        buttonGroup1.add(jRadioButton1_salidaAlta);
        jRadioButton1_salidaAlta.setText("Alta");

        buttonGroup1.add(jRadioButton2_salidaBaja);
        jRadioButton2_salidaBaja.setText("Baja");

        jButton2_guardar2.setText("Guardar");
        jButton2_guardar2.addActionListener(this::jButton2_guardar2ActionPerformed);

        jButton2_siguiente2.setText("Siguiente>");
        jButton2_siguiente2.addActionListener(this::jButton2_siguiente2ActionPerformed);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane3)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton2_salidaBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioButton1_salidaAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(jButton2_guardar2)
                .addGap(109, 109, 109)
                .addComponent(jButton2_siguiente2)
                .addContainerGap(536, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton1_salidaAlta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2_salidaBaja)
                .addGap(45, 45, 45)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2_guardar2)
                    .addComponent(jButton2_siguiente2))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", jPanel5);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Egreso"));

        jLabel15.setText("Paciente:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.addActionListener(this::jComboBox3ActionPerformed);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido Paterno", "Apellido Materno", "Hora salida", "Observaciones"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable1);

        jButton2_guardar3.setText("Guardar");
        jButton2_guardar3.addActionListener(this::jButton2_guardar3ActionPerformed);

        jButton2_siguiente3.setText("Siguiente>");
        jButton2_siguiente3.addActionListener(this::jButton2_siguiente3ActionPerformed);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(315, 315, 315)
                        .addComponent(jButton2_guardar3)
                        .addGap(47, 47, 47)
                        .addComponent(jButton2_siguiente3)))
                .addContainerGap(277, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 327, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2_guardar3)
                    .addComponent(jButton2_siguiente3))
                .addGap(276, 276, 276))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab3", jPanel8);

        jTable2_TablaPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido Paterno ", "Apellido Materno", "Genero", "Edad", "Peso", "Fecha registro", "Hora registro", "Alergias", "Observaciones"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTable2_TablaPacientes);

        jTextField2_buscar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2_buscar1KeyReleased(evt);
            }
        });

        jButton2_buscar1.setText("Buscar");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jTextField2_buscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jButton2_buscar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(65, 65, 65)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2_buscar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2_buscar1))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(518, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab4", jPanel10);

        jScrollPane4.setViewportView(jTabbedPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 122, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1_nombreActionPerformed

    private void jTextField1_apellidomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1_apellidomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1_apellidomActionPerformed

    private void jButton1_GuardarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_GuardarFechaActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        jTextField2_hora.setText(sdf.format(new Date()));
        // Sincronizar también el JDateChooser con hoy
        jDateChooser1_FechaActual.setDate(new Date());
    }//GEN-LAST:event_jButton1_GuardarFechaActionPerformed

    private void jButton2_guardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_guardar1ActionPerformed
        // TODO add your handling code here:
        // Patrón: solo letras (incluye acentos, ñ) y espacios; nada de números ni símbolos
        String patronSoloLetras = "^[A-Za-zÁÉÍÓÚáéíóúÑñÜü ]+$";
        // 1. Validar que los campos no estén vacíos
    String nombre = jTextField1_nombre.getText().trim();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "El nombre es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!nombre.matches(patronSoloLetras)) {
            JOptionPane.showMessageDialog(this,
                    "El nombre solo puede contener letras. No se permiten números ni caracteres especiales.",
                    "Dato inválido", JOptionPane.WARNING_MESSAGE);
            return;
        }
 
        String apellidoP = jTextField1_apellidop.getText().trim();
        if (apellidoP.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "El apellido paterno es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!apellidoP.matches(patronSoloLetras)) {
            JOptionPane.showMessageDialog(this,
                    "El apellido paterno solo puede contener letras. No se permiten números ni caracteres especiales.",
                    "Dato inválido", JOptionPane.WARNING_MESSAGE);
            return;
        }
     
 
        String apellidoM = jTextField1_apellidom.getText().trim();
         if (!apellidoM.isEmpty() && !apellidoM.matches(patronSoloLetras)) {
            JOptionPane.showMessageDialog(this,
                    "El apellido materno solo puede contener letras. No se permiten números ni caracteres especiales.",
                    "Dato inválido", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String genero    = (String) jComboBox1_genero.getSelectedItem();
        Date   fechaNac  = jCalendar1_fechaNacimiento.getDate();
 
        if (fechaNac == null) {
            JOptionPane.showMessageDialog(this,
                    "Selecciona la fecha de nacimiento.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Validar que la fecha de nacimiento no sea futura (no mayor al año/fecha actual)
        if (fechaNac.after(new Date())) {
            JOptionPane.showMessageDialog(this,
                    "La fecha de nacimiento no puede ser mayor a la fecha actual.",
                    "Fecha inválida", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
 
        double peso;
        try {
            peso = Double.parseDouble(jTextField2_peso.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "El peso debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
 
        // ── Llamar al controlador con datos primitivos ─────────
        controlador.guardarIngreso(nombre, apellidoP, apellidoM, genero, fechaNac, peso);
 
        // ── Actualizar la tabla de pacientes (Tab 4) ───────────
        refrescarTabla(controlador.getTodos());
 
        JOptionPane.showMessageDialog(this, "Paciente registrado correctamente.");
        limpiarTab1();
    }//GEN-LAST:event_jButton2_guardar1ActionPerformed

    private void jTextField2_horaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2_horaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2_horaActionPerformed

    private void jTextField2_buscar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2_buscar1KeyReleased
        // TODO add your handling code here:
        /**String busqueda = jTextField2_buscar1.getText().trim();
    ArrayList<Paciente> resultados = controlador.buscarPorNombre(busqueda);
    actualizarTabla(resultados);*/
        buscarYMostrar();
    }//GEN-LAST:event_jTextField2_buscar1KeyReleased

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton2_guardar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_guardar3ActionPerformed
        // TODO add your handling code here:
        String seleccionado = (String) jComboBox3.getSelectedItem();
        if (seleccionado == null || seleccionado.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Selecciona un paciente para registrar el egreso.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
 
        controlador.registrarEgreso(seleccionado);
        JOptionPane.showMessageDialog(this, "Egreso registrado para: " + seleccionado);
    }//GEN-LAST:event_jButton2_guardar3ActionPerformed

    private void jButton2_siguiente3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_siguiente3ActionPerformed
        // TODO add your handling code here:
         jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_jButton2_siguiente3ActionPerformed

    private void jButton2_guardar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_guardar2ActionPerformed
        // TODO add your handling code here:
        String alergias      = jTextArea1_Alergias.getText().trim();
        String observaciones = jTextArea2_Observaciones2.getText().trim();
        String diagnostico   = jTextArea1_diagnostico.getText().trim();
 
        // Determinar tipo de salida desde los RadioButtons
        String tipoSalida = jRadioButton1_salidaAlta.isSelected() ? "Alta" : "Baja";
 
        // Necesitamos el nombre del paciente activo.
        // Aquí se toma del campo buscar; en un flujo real podrías guardar el nombre
        // del último ingresado como variable de instancia.
        String nombrePaciente = jTextField2_buscar1.getText().trim();
        if (nombrePaciente.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Busca al paciente en Tab 4 o escribe su nombre en el buscador.",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
 
        controlador.guardarConsulta(nombrePaciente, alergias, observaciones,
                                    diagnostico, tipoSalida);
 
        JOptionPane.showMessageDialog(this, "Consulta guardada correctamente.");
    }//GEN-LAST:event_jButton2_guardar2ActionPerformed

    private void jTextField2_fechaNacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2_fechaNacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2_fechaNacActionPerformed

    private void jButton2_siguiente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_siguiente1ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jButton2_siguiente1ActionPerformed

    private void jButton2_siguiente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_siguiente2ActionPerformed
        // TODO add your handling code here:
         jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jButton2_siguiente2ActionPerformed

     private void buscarYMostrar() {
        String texto = jTextField2_buscar1.getText().trim();
        if (texto.isEmpty()) {
            refrescarTabla(controlador.getTodos());
        } else {
            ArrayList<Paciente> resultados = controlador.buscarPorNombre(texto);
            refrescarTabla(resultados);
        }
    }
     
     private void refrescarTabla(ArrayList<Paciente> lista) {
        DefaultTableModel modelo = (DefaultTableModel) jTable2_TablaPacientes.getModel();
        modelo.setRowCount(0); // limpiar filas anteriores
 
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
 
        for (Paciente p : lista) {
            modelo.addRow(new Object[]{
                p.getNombre(),
                p.getApellidoPaterno(),
                p.getApellidoMaterno(),
                p.getGenero(),
                p.getEdad(),
                p.getPeso(),
                p.getFechaNacimiento() != null
                        ? new SimpleDateFormat("dd/MM/yyyy").format(p.getFechaNacimiento()) : "",
                p.getHoraRegistro() != null ? sdf.format(p.getHoraRegistro()) : "",
                p.getAlergias(),
                p.getObservaciones()
            });
        }
    }
 
    
    private void limpiarTab1() {
        jTextField1_nombre.setText("");
        jTextField1_apellidop.setText("");
        jTextField1_apellidom.setText("");
        jTextField2_peso.setText("");
        jTextField2_edad.setText("");
        jComboBox1_genero.setSelectedIndex(0);
    }
    
    private int calcularEdadDesde(Date fechaNacimiento) {
        java.util.Calendar hoy = java.util.Calendar.getInstance();
        java.util.Calendar nac = java.util.Calendar.getInstance();
        nac.setTime(fechaNacimiento);
        int anios = hoy.get(java.util.Calendar.YEAR) - nac.get(java.util.Calendar.YEAR);
        if (hoy.get(java.util.Calendar.MONTH) < nac.get(java.util.Calendar.MONTH) ||
           (hoy.get(java.util.Calendar.MONTH) == nac.get(java.util.Calendar.MONTH) &&
            hoy.get(java.util.Calendar.DAY_OF_MONTH) < nac.get(java.util.Calendar.DAY_OF_MONTH))) {
            anios--;
        }
        return anios;
    }
/*
    private void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
    /*
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /*
        java.awt.EventQueue.invokeLater(() -> new Vista().setVisible(true));
    }*/
        
    
        public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
 
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            Controlador controlador = new Controlador();
            new Vista(controlador).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton1_GuardarFecha;
    private javax.swing.JButton jButton2_buscar1;
    private javax.swing.JButton jButton2_guardar1;
    private javax.swing.JButton jButton2_guardar2;
    private javax.swing.JButton jButton2_guardar3;
    private javax.swing.JButton jButton2_siguiente1;
    private javax.swing.JButton jButton2_siguiente2;
    private javax.swing.JButton jButton2_siguiente3;
    private com.toedter.calendar.JCalendar jCalendar1_fechaNacimiento;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox1_genero;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser1_FechaActual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1_salidaAlta;
    private javax.swing.JRadioButton jRadioButton2_salidaBaja;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane4_Observaciones1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2_TablaPacientes;
    private javax.swing.JTextArea jTextArea1_Alergias;
    private javax.swing.JTextArea jTextArea1_diagnostico;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea2_Observaciones2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField1_apellidom;
    private javax.swing.JTextField jTextField1_apellidop;
    private javax.swing.JTextField jTextField1_nombre;
    private javax.swing.JTextField jTextField2_buscar1;
    private javax.swing.JTextField jTextField2_edad;
    private javax.swing.JTextField jTextField2_fechaNac;
    private javax.swing.JTextField jTextField2_hora;
    private javax.swing.JTextField jTextField2_peso;
    // End of variables declaration//GEN-END:variables
}
