/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package com.mycompany.practicaHospital;

/**
 *
 * @author angel
 */
public class Hospital extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Hospital.class.getName());

    /**
     * Creates new form Hospital
     */
 private PanelListaMedicamentos panelMedicamentosReceta;
    private javax.swing.JComboBox<Paciente> jComboBoxPacienteReceta;
    private javax.swing.JTextArea jTextAreaIndicaciones;

    public Hospital() {
        initComponents();
        jTabbedPane1.setEnabledAt(2, false);
        cargarPacientesExistentes();
        construirPestanaReceta();
    }
    private void construirPestanaReceta() {
        javax.swing.JPanel panelReceta = new javax.swing.JPanel(new java.awt.BorderLayout(10, 10));
        panelReceta.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        javax.swing.JPanel panelSuperior = new javax.swing.JPanel(new java.awt.GridLayout(2, 1, 5, 5));

        jComboBoxPacienteReceta = new javax.swing.JComboBox<>();
        for (Paciente p : controlador.getListaPacientes()) {
            jComboBoxPacienteReceta.addItem(p);
        }
        javax.swing.JPanel filaPaciente = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        filaPaciente.add(new javax.swing.JLabel("Paciente:"));
        filaPaciente.add(jComboBoxPacienteReceta);
        panelSuperior.add(filaPaciente);

        jTextAreaIndicaciones = new javax.swing.JTextArea(3, 40);
        jTextAreaIndicaciones.setLineWrap(true);
        jTextAreaIndicaciones.setWrapStyleWord(true);
        javax.swing.JPanel filaIndicaciones = new javax.swing.JPanel(new java.awt.BorderLayout());
        filaIndicaciones.add(new javax.swing.JLabel("Indicaciones generales:"), java.awt.BorderLayout.NORTH);
        filaIndicaciones.add(new javax.swing.JScrollPane(jTextAreaIndicaciones), java.awt.BorderLayout.CENTER);
        panelSuperior.add(filaIndicaciones);

        panelReceta.add(panelSuperior, java.awt.BorderLayout.NORTH);

        panelMedicamentosReceta = new PanelListaMedicamentos();
        panelReceta.add(panelMedicamentosReceta, java.awt.BorderLayout.CENTER);

        javax.swing.JButton botonGenerarReceta = new javax.swing.JButton("Generar receta");
        botonGenerarReceta.addActionListener(e -> generarRecetaActionPerformed());
        javax.swing.JPanel panelBoton = new javax.swing.JPanel();
        panelBoton.add(botonGenerarReceta);
        panelReceta.add(panelBoton, java.awt.BorderLayout.SOUTH);

        jTabbedPane1.addTab("Receta", panelReceta);
    }

    private void generarRecetaActionPerformed() {
        Paciente paciente = (Paciente) jComboBoxPacienteReceta.getSelectedItem();
        if (paciente == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecciona un paciente.");
            return;
        }

        int idConsulta = Modelo.obtenerUltimaConsultaId(paciente.getIdPaciente());
        if (idConsulta <= 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Este paciente no tiene ninguna consulta registrada todavia.");
            return;
        }

        String indicaciones = jTextAreaIndicaciones.getText().trim();
        java.util.List<DetalleReceta> medicamentos = panelMedicamentosReceta.obtenerMedicamentos();

        boolean guardado = controlador.registrarReceta(idConsulta, indicaciones, medicamentos);
        if (!guardado) {
            javax.swing.JOptionPane.showMessageDialog(this, "No se pudo guardar la receta. Verifica los datos.");
            return;
        }

        Receta receta = new Receta(new java.sql.Timestamp(System.currentTimeMillis()), indicaciones, idConsulta);
        String nombreArchivo = "receta_" + paciente.getIdPaciente() + "_" + System.currentTimeMillis() + ".pdf";
        boolean pdfOk = GeneradorPDF.generarRecetaPDF(paciente, receta, medicamentos, nombreArchivo);

        if (pdfOk) {
            jTextAreaIndicaciones.setText("");
            panelMedicamentosReceta.limpiar();
            try {
                java.io.File archivoPdf = new java.io.File(nombreArchivo);
                if (java.awt.Desktop.isDesktopSupported()) {
                    java.awt.Desktop.getDesktop().open(archivoPdf);
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Receta guardada en: " + nombreArchivo);
                }
            } catch (java.io.IOException ex) {
                javax.swing.JOptionPane.showMessageDialog(this, "Receta guardada, pero no se pudo abrir automaticamente: " + nombreArchivo);
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Receta guardada, pero hubo un error al generar el PDF.");
        }
    }

    // Trae los pacientes ya guardados en la BD y los pinta en la tabla y el combo box
    private void cargarPacientesExistentes() {
        controlador.cargarPacientesDesdeBD();
        javax.swing.table.DefaultTableModel modeloTabla = (javax.swing.table.DefaultTableModel) jTableVistaPacientes.getModel();
        for (Paciente p : controlador.getListaPacientes()) {
            modeloTabla.addRow(new Object[]{p.getNombre(), p.getApPat(), p.getApMat(), p.getEdad(), p.getGenero(), p.getPeso()});
            jComboBoxEleccionCliente.addItem(p.getNombre() + " " + p.getApPat() + " " + p.getApMat());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldApPat = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldApMat = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldPeso = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxGenero = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jDateChooserFechaNacimientos = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldEdad = new javax.swing.JTextField();
        jButtonIngreso = new javax.swing.JButton();
        jSpinnerFechaHora = new javax.swing.JSpinner();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldAlergias = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextFieldObservacionesConsulta = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextFieldDiagnosticoConsulta = new javax.swing.JTextField();
        jButtonRegistroSintomas = new javax.swing.JButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jComboBoxEleccionCliente = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButtonEgreso = new javax.swing.JButton();
        jSpinnerHoraSalida = new javax.swing.JSpinner();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextFieldObservacionesEgreso = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jComboBoxEleccionEgreso = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVistaPacientes = new javax.swing.JTable();
        jTextField6 = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jButtonVerDetalles = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Inserte los datos del paciente");

        jLabel7.setText("Nombre");

        jLabel8.setText("Apellido P");

        jLabel9.setText("Apellido M");

        jLabel10.setText("Genero");

        jLabel13.setText("Peso");

        jLabel14.setText("Fecha de nacimiento");

        jComboBoxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hombre", "Mujer" }));

        jLabel15.setText("Fecha y Hora");

        jLabel16.setText("Edad");

        jTextFieldEdad.setEditable(false);

        jButtonIngreso.setText("Ingresar");
        jButtonIngreso.addActionListener(this::jButtonIngresoActionPerformed);

        jSpinnerFechaHora.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.HOUR_OF_DAY));

        // Layout adaptable: crece/decrece con la ventana sin deformar los controles
        jPanel2.setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbcIngreso = new java.awt.GridBagConstraints();
        gbcIngreso.insets = new java.awt.Insets(8, 8, 8, 8);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gbcIngreso.gridx = 0;
        gbcIngreso.gridy = 0;
        gbcIngreso.gridwidth = 6;
        gbcIngreso.anchor = java.awt.GridBagConstraints.CENTER;
        jPanel2.add(jLabel2, gbcIngreso);
        gbcIngreso.gridwidth = 1;

        // Fila: Nombre / Apellido P / Apellido M
        gbcIngreso.gridy = 1;
        gbcIngreso.gridx = 0; gbcIngreso.fill = java.awt.GridBagConstraints.NONE; gbcIngreso.weightx = 0; gbcIngreso.anchor = java.awt.GridBagConstraints.EAST;
        jPanel2.add(jLabel7, gbcIngreso);
        gbcIngreso.gridx = 1; gbcIngreso.fill = java.awt.GridBagConstraints.HORIZONTAL; gbcIngreso.weightx = 0.33; gbcIngreso.anchor = java.awt.GridBagConstraints.WEST;
        jPanel2.add(jTextFieldNombre, gbcIngreso);
        gbcIngreso.gridx = 2; gbcIngreso.fill = java.awt.GridBagConstraints.NONE; gbcIngreso.weightx = 0; gbcIngreso.anchor = java.awt.GridBagConstraints.EAST;
        jPanel2.add(jLabel8, gbcIngreso);
        gbcIngreso.gridx = 3; gbcIngreso.fill = java.awt.GridBagConstraints.HORIZONTAL; gbcIngreso.weightx = 0.33; gbcIngreso.anchor = java.awt.GridBagConstraints.WEST;
        jPanel2.add(jTextFieldApPat, gbcIngreso);
        gbcIngreso.gridx = 4; gbcIngreso.fill = java.awt.GridBagConstraints.NONE; gbcIngreso.weightx = 0; gbcIngreso.anchor = java.awt.GridBagConstraints.EAST;
        jPanel2.add(jLabel9, gbcIngreso);
        gbcIngreso.gridx = 5; gbcIngreso.fill = java.awt.GridBagConstraints.HORIZONTAL; gbcIngreso.weightx = 0.33; gbcIngreso.anchor = java.awt.GridBagConstraints.WEST;
        jPanel2.add(jTextFieldApMat, gbcIngreso);

        // Fila: Genero / Peso / Edad
        gbcIngreso.gridy = 2;
        gbcIngreso.gridx = 0; gbcIngreso.fill = java.awt.GridBagConstraints.NONE; gbcIngreso.weightx = 0; gbcIngreso.anchor = java.awt.GridBagConstraints.EAST;
        jPanel2.add(jLabel10, gbcIngreso);
        gbcIngreso.gridx = 1; gbcIngreso.fill = java.awt.GridBagConstraints.HORIZONTAL; gbcIngreso.weightx = 0.33; gbcIngreso.anchor = java.awt.GridBagConstraints.WEST;
        jPanel2.add(jComboBoxGenero, gbcIngreso);
        gbcIngreso.gridx = 2; gbcIngreso.fill = java.awt.GridBagConstraints.NONE; gbcIngreso.weightx = 0; gbcIngreso.anchor = java.awt.GridBagConstraints.EAST;
        jPanel2.add(jLabel13, gbcIngreso);
        gbcIngreso.gridx = 3; gbcIngreso.fill = java.awt.GridBagConstraints.HORIZONTAL; gbcIngreso.weightx = 0.33; gbcIngreso.anchor = java.awt.GridBagConstraints.WEST;
        jPanel2.add(jTextFieldPeso, gbcIngreso);
        gbcIngreso.gridx = 4; gbcIngreso.fill = java.awt.GridBagConstraints.NONE; gbcIngreso.weightx = 0; gbcIngreso.anchor = java.awt.GridBagConstraints.EAST;
        jPanel2.add(jLabel16, gbcIngreso);
        gbcIngreso.gridx = 5; gbcIngreso.fill = java.awt.GridBagConstraints.HORIZONTAL; gbcIngreso.weightx = 0.33; gbcIngreso.anchor = java.awt.GridBagConstraints.WEST;
        jPanel2.add(jTextFieldEdad, gbcIngreso);

        // Fila: Fecha de nacimiento / Fecha y hora
        gbcIngreso.gridy = 3;
        gbcIngreso.gridx = 0; gbcIngreso.gridwidth = 1; gbcIngreso.fill = java.awt.GridBagConstraints.NONE; gbcIngreso.weightx = 0; gbcIngreso.anchor = java.awt.GridBagConstraints.EAST;
        jPanel2.add(jLabel14, gbcIngreso);
        gbcIngreso.gridx = 1; gbcIngreso.gridwidth = 2; gbcIngreso.fill = java.awt.GridBagConstraints.HORIZONTAL; gbcIngreso.weightx = 0.66; gbcIngreso.anchor = java.awt.GridBagConstraints.WEST;
        jPanel2.add(jDateChooserFechaNacimientos, gbcIngreso);
        gbcIngreso.gridwidth = 1;
        gbcIngreso.gridx = 3; gbcIngreso.fill = java.awt.GridBagConstraints.NONE; gbcIngreso.weightx = 0; gbcIngreso.anchor = java.awt.GridBagConstraints.EAST;
        jPanel2.add(jLabel15, gbcIngreso);
        gbcIngreso.gridx = 4; gbcIngreso.gridwidth = 2; gbcIngreso.fill = java.awt.GridBagConstraints.HORIZONTAL; gbcIngreso.weightx = 0.66; gbcIngreso.anchor = java.awt.GridBagConstraints.WEST;
        jPanel2.add(jSpinnerFechaHora, gbcIngreso);
        gbcIngreso.gridwidth = 1;

        // Boton Ingresar, centrado, con espacio flexible debajo
        gbcIngreso.gridx = 0; gbcIngreso.gridy = 4; gbcIngreso.gridwidth = 6;
        gbcIngreso.fill = java.awt.GridBagConstraints.NONE; gbcIngreso.weightx = 0; gbcIngreso.weighty = 1.0;
        gbcIngreso.anchor = java.awt.GridBagConstraints.CENTER;
        jPanel2.add(jButtonIngreso, gbcIngreso);

        jTabbedPane1.addTab("Ingreso", jPanel2);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Registro de sintomas");

        jLabel17.setText("Alergias");

        jLabel18.setText("Observaciones");

        jLabel19.setText("Diagnostico");

        jButtonRegistroSintomas.setText("Registrar");
        jButtonRegistroSintomas.addActionListener(this::jButtonRegistroSintomasActionPerformed);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Salida");
        jRadioButton2.addActionListener(this::jRadioButton2ActionPerformed);

        jComboBoxEleccionCliente.addActionListener(this::jComboBoxEleccionClienteActionPerformed);

        jLabel24.setText("Elegir paciente");

        // Layout adaptable: crece/decrece con la ventana sin deformar los controles
        jPanel4.setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbcConsulta = new java.awt.GridBagConstraints();
        gbcConsulta.insets = new java.awt.Insets(8, 8, 8, 8);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gbcConsulta.gridx = 0; gbcConsulta.gridy = 0; gbcConsulta.gridwidth = 2;
        gbcConsulta.anchor = java.awt.GridBagConstraints.CENTER;
        jPanel4.add(jLabel4, gbcConsulta);
        gbcConsulta.gridwidth = 1;

        gbcConsulta.gridx = 0; gbcConsulta.gridy = 1; gbcConsulta.fill = java.awt.GridBagConstraints.NONE; gbcConsulta.weightx = 0; gbcConsulta.anchor = java.awt.GridBagConstraints.EAST;
        jPanel4.add(jLabel24, gbcConsulta);
        gbcConsulta.gridx = 1; gbcConsulta.fill = java.awt.GridBagConstraints.HORIZONTAL; gbcConsulta.weightx = 1.0; gbcConsulta.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(jComboBoxEleccionCliente, gbcConsulta);

        gbcConsulta.gridx = 0; gbcConsulta.gridy = 2; gbcConsulta.fill = java.awt.GridBagConstraints.NONE; gbcConsulta.weightx = 0; gbcConsulta.anchor = java.awt.GridBagConstraints.EAST;
        jPanel4.add(jLabel17, gbcConsulta);
        gbcConsulta.gridx = 1; gbcConsulta.fill = java.awt.GridBagConstraints.HORIZONTAL; gbcConsulta.weightx = 1.0; gbcConsulta.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(jTextFieldAlergias, gbcConsulta);

        gbcConsulta.gridx = 0; gbcConsulta.gridy = 3; gbcConsulta.fill = java.awt.GridBagConstraints.NONE; gbcConsulta.weightx = 0; gbcConsulta.anchor = java.awt.GridBagConstraints.EAST;
        jPanel4.add(jLabel18, gbcConsulta);
        gbcConsulta.gridx = 1; gbcConsulta.fill = java.awt.GridBagConstraints.HORIZONTAL; gbcConsulta.weightx = 1.0; gbcConsulta.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(jTextFieldObservacionesConsulta, gbcConsulta);

        gbcConsulta.gridx = 0; gbcConsulta.gridy = 4; gbcConsulta.fill = java.awt.GridBagConstraints.NONE; gbcConsulta.weightx = 0; gbcConsulta.anchor = java.awt.GridBagConstraints.EAST;
        jPanel4.add(jLabel19, gbcConsulta);
        gbcConsulta.gridx = 1; gbcConsulta.fill = java.awt.GridBagConstraints.HORIZONTAL; gbcConsulta.weightx = 1.0; gbcConsulta.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(jTextFieldDiagnosticoConsulta, gbcConsulta);

        javax.swing.JPanel panelBotonesConsulta = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));
        panelBotonesConsulta.add(jButtonRegistroSintomas);
        panelBotonesConsulta.add(jRadioButton2);
        gbcConsulta.gridx = 0; gbcConsulta.gridy = 5; gbcConsulta.gridwidth = 2;
        gbcConsulta.fill = java.awt.GridBagConstraints.NONE; gbcConsulta.weightx = 0; gbcConsulta.weighty = 1.0;
        gbcConsulta.anchor = java.awt.GridBagConstraints.CENTER;
        jPanel4.add(panelBotonesConsulta, gbcConsulta);

        jTabbedPane1.addTab("Consulta", jPanel4);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Aca la weada que egresa al paciente");

        jButtonEgreso.setText("Egreso");
        jButtonEgreso.addActionListener(this::jButtonEgresoActionPerformed);

        jSpinnerHoraSalida.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.AM_PM));

        jLabel20.setText("Hora Salida");

        jLabel21.setText("Observaciones");

        jLabel25.setText("Elegir paciente");

        jComboBoxEleccionEgreso.addActionListener(this::jComboBoxEleccionEgresoActionPerformed);

        // Layout adaptable: crece/decrece con la ventana sin deformar los controles
        jPanel3.setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbcEgreso = new java.awt.GridBagConstraints();
        gbcEgreso.insets = new java.awt.Insets(8, 8, 8, 8);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gbcEgreso.gridx = 0; gbcEgreso.gridy = 0; gbcEgreso.gridwidth = 2;
        gbcEgreso.anchor = java.awt.GridBagConstraints.CENTER;
        jPanel3.add(jLabel3, gbcEgreso);
        gbcEgreso.gridwidth = 1;

        gbcEgreso.gridx = 0; gbcEgreso.gridy = 1; gbcEgreso.fill = java.awt.GridBagConstraints.NONE; gbcEgreso.weightx = 0; gbcEgreso.anchor = java.awt.GridBagConstraints.EAST;
        jPanel3.add(jLabel25, gbcEgreso);
        gbcEgreso.gridx = 1; gbcEgreso.fill = java.awt.GridBagConstraints.HORIZONTAL; gbcEgreso.weightx = 1.0; gbcEgreso.anchor = java.awt.GridBagConstraints.WEST;
        jPanel3.add(jComboBoxEleccionEgreso, gbcEgreso);

        gbcEgreso.gridx = 0; gbcEgreso.gridy = 2; gbcEgreso.fill = java.awt.GridBagConstraints.NONE; gbcEgreso.weightx = 0; gbcEgreso.anchor = java.awt.GridBagConstraints.EAST;
        jPanel3.add(jLabel20, gbcEgreso);
        gbcEgreso.gridx = 1; gbcEgreso.fill = java.awt.GridBagConstraints.HORIZONTAL; gbcEgreso.weightx = 1.0; gbcEgreso.anchor = java.awt.GridBagConstraints.WEST;
        jPanel3.add(jSpinnerHoraSalida, gbcEgreso);

        gbcEgreso.gridx = 0; gbcEgreso.gridy = 3; gbcEgreso.fill = java.awt.GridBagConstraints.NONE; gbcEgreso.weightx = 0; gbcEgreso.anchor = java.awt.GridBagConstraints.EAST;
        jPanel3.add(jLabel21, gbcEgreso);
        gbcEgreso.gridx = 1; gbcEgreso.fill = java.awt.GridBagConstraints.HORIZONTAL; gbcEgreso.weightx = 1.0; gbcEgreso.anchor = java.awt.GridBagConstraints.WEST;
        jPanel3.add(jTextFieldObservacionesEgreso, gbcEgreso);

        gbcEgreso.gridx = 0; gbcEgreso.gridy = 4; gbcEgreso.gridwidth = 2;
        gbcEgreso.fill = java.awt.GridBagConstraints.NONE; gbcEgreso.weightx = 0; gbcEgreso.weighty = 1.0;
        gbcEgreso.anchor = java.awt.GridBagConstraints.CENTER;
        jPanel3.add(jButtonEgreso, gbcEgreso);

        jTabbedPane1.addTab("Egreso", jPanel3);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Muestra de todos los pacientes");

        jTableVistaPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Ap Pat", "Ap Mat", "Edad", "Genero", "Peso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableVistaPacientes);

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(this::jButtonBuscarActionPerformed);

        jLabel22.setText("Hora Salida");

        jLabel23.setText("Bsuqueda por Nombre");

        jButtonVerDetalles.setText("Ver detalles");
        jButtonVerDetalles.addActionListener(this::jButtonVerDetallesActionPerformed);

        // Layout adaptable: la tabla (jScrollPane1) ocupa todo el espacio extra al agrandar la ventana
        jPanel1.setLayout(new java.awt.BorderLayout(10, 10));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 15, 10, 15));

        javax.swing.JPanel panelSuperiorVista = new javax.swing.JPanel(new java.awt.GridLayout(2, 1, 5, 5));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelSuperiorVista.add(jLabel5);

        javax.swing.JPanel filaBusquedaVista = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));
        filaBusquedaVista.add(jLabel23);
        filaBusquedaVista.add(jTextField6);
        filaBusquedaVista.add(jButtonBuscar);
        filaBusquedaVista.add(jButtonVerDetalles);
        filaBusquedaVista.add(jLabel22);
        panelSuperiorVista.add(filaBusquedaVista);

        jPanel1.add(panelSuperiorVista, java.awt.BorderLayout.NORTH);
        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Vista de pacientes", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        int indice = jComboBoxEleccionCliente.getSelectedIndex();

            if (jRadioButton2.isSelected()) {
            jTabbedPane1.setEnabledAt(2, true);

                if (indice >= 0) {
                    Paciente p = controlador.obtenerPacientePorIndice(indice);
                    if (p == null) { return; }

                    if (!pacientesEgreso.contains(p)) {
                        jComboBoxEleccionEgreso.addItem(p.getNombre() + " " + p.getApPat() + " " + p.getApMat());
                        pacientesEgreso.add(p);
                    }
                }
            } else {
                jTabbedPane1.setEnabledAt(2, false);

                if (indice >= 0) {
                    Paciente p = controlador.obtenerPacientePorIndice(indice);
                    if (p == null) { return; }
                    int posicion = pacientesEgreso.indexOf(p);

                    if (posicion >= 0) {
                        jComboBoxEleccionEgreso.removeItemAt(posicion);
                        pacientesEgreso.remove(posicion);
                    }
                }
            }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jButtonIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIngresoActionPerformed
        // TODO add your handling code here:
        try {
        String nombre = jTextFieldNombre.getText();
        String apPat = jTextFieldApPat.getText();
        String apMat = jTextFieldApMat.getText();
        String genero = jComboBoxGenero.getSelectedItem().toString();
        String peso = jTextFieldPeso.getText();
        java.util.Date fecha = jDateChooserFechaNacimientos.getDate();

        if (!controlador.esSoloLetras(nombre)) {
            javax.swing.JOptionPane.showMessageDialog(this, "El nombre solo debe contener letras.");
            return;
        }

        if (!controlador.esSoloLetras(apPat)) {
            javax.swing.JOptionPane.showMessageDialog(this, "El apellido paterno solo debe contener letras.");
            return;
        }

        if (!controlador.esSoloLetras(apMat)) {
            javax.swing.JOptionPane.showMessageDialog(this, "El apellido materno solo debe contener letras.");
            return;
        }

        if (!controlador.esSoloNumeros(peso)) {
            javax.swing.JOptionPane.showMessageDialog(this, "El peso solo debe contener números.");
            return;
        }

        if (fecha == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecciona la fecha de nacimiento.");
            return;
        }

       double pesoValor = Double.parseDouble(peso);
        java.util.Date fechaHoraIngreso = (java.util.Date) jSpinnerFechaHora.getValue();

        java.time.LocalDate fechaNacLocal = fecha.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        int edadCalculada = java.time.Period.between(fechaNacLocal, java.time.LocalDate.now()).getYears();
        jTextFieldEdad.setText(String.valueOf(edadCalculada));

        boolean creado = controlador.crearPaciente(nombre, apPat, apMat, edadCalculada, genero, pesoValor,
        fecha, fechaHoraIngreso);
        if (creado) {
            javax.swing.table.DefaultTableModel modeloTabla = (javax.swing.table.DefaultTableModel) jTableVistaPacientes.getModel();
            modeloTabla.addRow(new Object[]{nombre, apPat, apMat, edadCalculada, genero, peso});
            jComboBoxEleccionCliente.addItem(nombre + " " + apPat + " " + apMat);
            jTextFieldNombre.setText("");
            jTextFieldApPat.setText("");
            jTextFieldApMat.setText("");
            jTextFieldPeso.setText("");
            jTextFieldEdad.setText("");
            jDateChooserFechaNacimientos.setDate(null);
            jComboBoxGenero.setSelectedIndex(0);
            jSpinnerFechaHora.setValue(new java.util.Date());
            javax.swing.JOptionPane.showMessageDialog(this, "Paciente creado exitosamente en el Modelo.");
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "No se pudo crear el paciente. Verifique el nombre.");
        }
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error al registrar al paciente: " + e.getMessage());
    }
    }//GEN-LAST:event_jButtonIngresoActionPerformed

    private void jButtonRegistroSintomasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistroSintomasActionPerformed
        // TODO add your handling code here:
        try {
        int indice = jComboBoxEleccionCliente.getSelectedIndex();

        if (indice < 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecciona un paciente.");
            return;
        }

        String alergias = jTextFieldAlergias.getText();
        String observaciones = jTextFieldObservacionesConsulta.getText();
        String diagnostico = jTextFieldDiagnosticoConsulta.getText();

        if (!controlador.esSoloLetras(alergias)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Las alergias solo deben contener letras.");
            return;
        }

        if (!controlador.esSoloLetras(observaciones)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Las observaciones solo deben contener letras.");
            return;
        }

        if (!controlador.esSoloLetras(diagnostico)) {
            javax.swing.JOptionPane.showMessageDialog(this, "El diagnóstico solo debe contener letras.");
            return;
        }

        boolean ok = controlador.registrarConsulta(indice, alergias, observaciones, diagnostico);

        if (ok) {
            jTextFieldAlergias.setText("");
            jTextFieldObservacionesConsulta.setText("");
            jTextFieldDiagnosticoConsulta.setText("");
            buttonGroup1.clearSelection();
            javax.swing.JOptionPane.showMessageDialog(this, "Consulta registrada correctamente.");
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al registrar la consulta.");
        }

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error al registrar la consulta: " + e.getMessage());
        }
    }//GEN-LAST:event_jButtonRegistroSintomasActionPerformed

    private void jComboBoxEleccionClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEleccionClienteActionPerformed
        // TODO add your handling code here:
        int indice = jComboBoxEleccionCliente.getSelectedIndex();
        if (indice < 0) {
            buttonGroup1.clearSelection();
            jTabbedPane1.setEnabledAt(2, false);
            return;
        }
        Paciente p = controlador.obtenerPacientePorIndice(indice);
        if (p == null) {
            return;
        }

        if (pacientesEgreso.contains(p)) {
            jRadioButton2.setSelected(true);
            jTabbedPane1.setEnabledAt(2, true);
        } else {
            buttonGroup1.clearSelection();
            jTabbedPane1.setEnabledAt(2, false);
        }
    }//GEN-LAST:event_jComboBoxEleccionClienteActionPerformed

    private void jButtonEgresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEgresoActionPerformed
    try {
        int posicion = jComboBoxEleccionEgreso.getSelectedIndex();

        if (posicion < 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecciona un paciente.");
            return;
        }

        Paciente p = pacientesEgreso.get(posicion);
        int indice = controlador.obtenerIndice(p);

        java.util.Date horaSalida = (java.util.Date) jSpinnerHoraSalida.getValue();

        String observaciones = jTextFieldObservacionesEgreso.getText();

        if (!controlador.esTextoValido(observaciones)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Las observaciones de egreso deben contener texto válido.");
            return;
        }

        boolean ok = controlador.registrarEgreso(indice, horaSalida, observaciones);

        if (ok) {
            String horaTexto = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm").format(horaSalida);
            jTextFieldObservacionesEgreso.setText("");
            javax.swing.JOptionPane.showMessageDialog(this, "Egreso registrado correctamente.\nHora: " + horaTexto);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al registrar el egreso.");
        }

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error al registrar el egreso: " + e.getMessage());
    }
    }//GEN-LAST:event_jButtonEgresoActionPerformed

    private void jComboBoxEleccionEgresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEleccionEgresoActionPerformed

    int posicion = jComboBoxEleccionEgreso.getSelectedIndex();

    if (posicion < 0 || posicion >= pacientesEgreso.size()) {
        jComboBoxEleccionEgreso.setToolTipText(null);
        jTextFieldObservacionesEgreso.setText("");
        return;
    }

    Paciente p = pacientesEgreso.get(posicion);
    if (p == null) {
        return;
    }

    // Carga datos reales del paciente elegido (via Controlador, no listas vacias)
    jComboBoxEleccionEgreso.setToolTipText(controlador.obtenerInfoCompleta(p));
    jSpinnerHoraSalida.setValue(new java.util.Date());
    jTextFieldObservacionesEgreso.setText("");

    }//GEN-LAST:event_jComboBoxEleccionEgresoActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:
        try {
        String texto = jTextField6.getText();

        if (!controlador.esSoloLetras(texto)) {
            javax.swing.JOptionPane.showMessageDialog(this, "La búsqueda solo debe contener letras.");
            return;
        }

        java.util.List<Paciente> resultados = controlador.buscarTodosPorNombre(texto);

        if (resultados.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "No se encontró al paciente.");
            return;
        }

        if (resultados.size() == 1) {
            mostrarDatosPaciente(resultados.get(0));
            return;
        }

        String[] opciones = new String[resultados.size()];
        for (int i = 0; i < resultados.size(); i++) {
            Paciente p = resultados.get(i);
            opciones[i] = p.getNombre() + " " + p.getApPat() + " " + p.getApMat() + " (Edad: " + p.getEdad() + ")";
        }

        String seleccion = (String) javax.swing.JOptionPane.showInputDialog(
            this,
            "Se encontraron varios pacientes con ese nombre. Selecciona uno:",
            "Pacientes encontrados",
            javax.swing.JOptionPane.QUESTION_MESSAGE,
            null,
            opciones,
            opciones[0]
        );

        if (seleccion != null) {
            int indiceElegido = java.util.Arrays.asList(opciones).indexOf(seleccion);
            mostrarDatosPaciente(resultados.get(indiceElegido));
        }

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error al buscar: " + e.getMessage());
    }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonVerDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerDetallesActionPerformed
        // TODO add your handling code here:
        try {
        int fila = jTableVistaPacientes.getSelectedRow();

        if (fila < 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecciona un paciente de la tabla.");
            return;
        }

        Paciente p = controlador.obtenerPacientePorIndice(fila);
        if (p == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "No se encontró el paciente seleccionado.");
            return;
        }
        mostrarDatosPaciente(p);

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error al mostrar los detalles: " + e.getMessage());
    }
    }//GEN-LAST:event_jButtonVerDetallesActionPerformed
    
    /**
     * @param args the command line arguments
     */
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
        java.awt.EventQueue.invokeLater(() -> new Hospital().setVisible(true));
    }

    private final Controlador controlador = new Controlador();
    private final java.util.List<Paciente> pacientesEgreso = new java.util.ArrayList<>();
    
    private void mostrarDatosPaciente(Paciente p) {
        String info = controlador.obtenerInfoCompleta(p);
        javax.swing.JOptionPane.showMessageDialog(this, info, "Datos del paciente", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }   

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEgreso;
    private javax.swing.JButton jButtonIngreso;
    private javax.swing.JButton jButtonRegistroSintomas;
    private javax.swing.JButton jButtonVerDetalles;
    private javax.swing.JComboBox<String> jComboBoxEleccionCliente;
    private javax.swing.JComboBox<String> jComboBoxEleccionEgreso;
    private javax.swing.JComboBox<String> jComboBoxGenero;
    private com.toedter.calendar.JDateChooser jDateChooserFechaNacimientos;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerFechaHora;
    private javax.swing.JSpinner jSpinnerHoraSalida;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableVistaPacientes;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextFieldAlergias;
    private javax.swing.JTextField jTextFieldApMat;
    private javax.swing.JTextField jTextFieldApPat;
    private javax.swing.JTextField jTextFieldDiagnosticoConsulta;
    private javax.swing.JTextField jTextFieldEdad;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldObservacionesConsulta;
    private javax.swing.JTextField jTextFieldObservacionesEgreso;
    private javax.swing.JTextField jTextFieldPeso;
    // End of variables declaration//GEN-END:variables
}
