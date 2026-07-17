/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaHospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Capa de acceso a datos (Modelo) para la base de datos "Hospital".
 * Aqui viven todas las consultas SQL del proyecto.
 *
 * @author angel
 */
public class Modelo {
    // Ajusta "topicos" al nombre real de tu base de datos si es distinto.
    private static String url = "jdbc:postgresql://localhost:5432/topicos?currentSchema=\"Hospital\"";
    private static String usuario = "postgres";
    private static String contraseña = "jaz";


    // CONEXION =========================================================
    public static Connection estadoConeccion() {
        Connection coneccion = null;
        try {
            coneccion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("~~ Conexion exitosa a la base de datos ~~");
            return coneccion;
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
            return coneccion;
        }
    }


    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~ PACIENTE ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // CREATE (Insertar) =========================================================
    // Devuelve el id_paciente generado, o -1 si algo fallo.
    public static int insertarPaciente(Paciente paciente) {
        String sql = "INSERT INTO pacientes (nombre, apellidop, apellidom, fecha_nacimiento, edad, "
                   + "genero, peso, fecha_hora_ingreso, creado_en) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) "
                   + "RETURNING id_paciente";
        try (Connection conn = estadoConeccion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, paciente.getNombre());
            pstmt.setString(2, paciente.getApPat());
            pstmt.setString(3, paciente.getApMat());
            pstmt.setDate(4, new java.sql.Date(paciente.getFechaNacimiento().getTime()));
            pstmt.setInt(5, paciente.getEdad());
            pstmt.setString(6, paciente.getGenero());
            pstmt.setDouble(7, paciente.getPeso());
            pstmt.setTimestamp(8, new java.sql.Timestamp(paciente.getFechaHoraIngreso().getTime()));
            pstmt.setTimestamp(9, new java.sql.Timestamp(paciente.getCreadoEn().getTime()));

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Paciente insertado correctamente.");
                    return rs.getInt("id_paciente");
                }
            }
            return -1;
        } catch (SQLException e) {
            System.out.println("Error al insertar paciente: " + e.getMessage());
            return -1;
        }
    }

    // REGRESAR (objetos completos, usado al iniciar el programa) =========================
    public static java.util.List<Paciente> obtenerPacientes() {
        java.util.List<Paciente> lista = new java.util.ArrayList<>();
        String sql = "SELECT id_paciente, nombre, apellidop, apellidom, fecha_nacimiento, edad, "
                   + "genero, peso, fecha_hora_ingreso, creado_en FROM pacientes ORDER BY id_paciente";
        try (Connection conn = estadoConeccion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Paciente p = new Paciente(
                    rs.getString("nombre"),
                    rs.getString("apellidop"),
                    rs.getString("apellidom"),
                    rs.getString("genero"),
                    rs.getDouble("peso"),
                    rs.getDate("fecha_nacimiento"),
                    rs.getTimestamp("fecha_hora_ingreso")
                );
                int idPaciente = rs.getInt("id_paciente");
                p.setIdPaciente(idPaciente);
                p.setEdad(rs.getInt("edad"));

                cargarUltimaConsulta(conn, p, idPaciente);
                cargarUltimoEgreso(conn, p, idPaciente);

                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar pacientes: " + e.getMessage());
        }
        return lista;
    }

    // Rellena alergias/observaciones/diagnostico con la consulta mas reciente del paciente (si tiene)
    private static void cargarUltimaConsulta(Connection conn, Paciente p, int idPaciente) {
        String sql = "SELECT alergias, observaciones_sintomas, diagnostico FROM consultas "
                   + "WHERE id_paciente = ? ORDER BY fecha_registro DESC LIMIT 1";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idPaciente);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    p.setAlergias(rs.getString("alergias"));
                    p.setObservacionesSintomas(rs.getString("observaciones_sintomas"));
                    p.setDiagnostico(rs.getString("diagnostico"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar consulta del paciente " + idPaciente + ": " + e.getMessage());
        }
    }

    // Rellena hora de salida/observaciones con el egreso mas reciente del paciente (si tiene)
    private static void cargarUltimoEgreso(Connection conn, Paciente p, int idPaciente) {
        String sql = "SELECT observaciones_egreso, hora_salida FROM egresos "
                   + "WHERE id_paciente = ? ORDER BY fecha_registro DESC LIMIT 1";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idPaciente);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    p.setObservacionesEgreso(rs.getString("observaciones_egreso"));
                    java.sql.Time hora = rs.getTime("hora_salida");
                    if (hora != null) {
                        p.setHoraSalida(new java.util.Date(hora.getTime()));
                    }
                    p.setEsSalida(true);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar egreso del paciente " + idPaciente + ": " + e.getMessage());
        }
    }

    // REGRESAR (imprime en consola) =========================================================
    public static void leerPaciente() {
        String sql = "SELECT id_paciente, nombre, apellidop, apellidom, fecha_nacimiento, edad, "
                   + "genero, peso, fecha_hora_ingreso, creado_en FROM pacientes";
        try (Connection conn = estadoConeccion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_paciente") +
                                   " | Nombre: " + rs.getString("nombre") +
                                   " | Apellido P: " + rs.getString("apellidop") +
                                   " | Apellido M: " + rs.getString("apellidom") +
                                   " | Nacimiento: " + rs.getDate("fecha_nacimiento") +
                                   " | Edad: " + rs.getInt("edad") +
                                   " | Genero: " + rs.getString("genero") +
                                   " | Peso: " + rs.getDouble("peso") +
                                   " | Ingreso: " + rs.getTimestamp("fecha_hora_ingreso"));
            }
        } catch (SQLException e) {
            System.out.println("Error al leer pacientes: " + e.getMessage());
        }
    }

    // UPDATE (Actualizar) =========================================================
    public static void actualizarPaciente(Paciente paciente) {
        String sql = "UPDATE pacientes SET nombre = ?, apellidop = ?, apellidom = ?, fecha_nacimiento = ?, "
                   + "edad = ?, genero = ?, peso = ? WHERE id_paciente = ?";
        try (Connection conn = estadoConeccion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, paciente.getNombre());
            pstmt.setString(2, paciente.getApPat());
            pstmt.setString(3, paciente.getApMat());
            pstmt.setDate(4, new java.sql.Date(paciente.getFechaNacimiento().getTime()));
            pstmt.setInt(5, paciente.getEdad());
            pstmt.setString(6, paciente.getGenero());
            pstmt.setDouble(7, paciente.getPeso());
            pstmt.setInt(8, paciente.getIdPaciente());
            pstmt.executeUpdate();
            System.out.println("Paciente actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar paciente: " + e.getMessage());
        }
    }

    // DELETE (Eliminar) =========================================================
    public static void eliminarPaciente(int idPaciente) {
        String sql = "DELETE FROM pacientes WHERE id_paciente = ?";
        try (Connection conn = estadoConeccion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idPaciente);
            pstmt.executeUpdate();
            System.out.println("Paciente eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar paciente: " + e.getMessage());
        }
    }


    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~ DOCTOR ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // CREATE (Insertar) =========================================================
    public static void insertarDoctor(Doctor doctor) {
        String sql = "INSERT INTO doctor (nombre_doctor, num_cedula, apellidop) VALUES (?, ?, ?)";
        try (Connection conn = estadoConeccion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, doctor.getNombreDoctor());
            pstmt.setString(2, doctor.getNumCedula());
            pstmt.setString(3, doctor.getApellidoP());
            pstmt.executeUpdate();
            System.out.println("Doctor insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar doctor: " + e.getMessage());
        }
    }

    // REGRESAR =========================================================
    public static void leerDoctor() {
        String sql = "SELECT id_doctor, nombre_doctor, num_cedula, apellidop FROM doctor";
        try (Connection conn = estadoConeccion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_doctor") +
                                   " | Nombre: " + rs.getString("nombre_doctor") +
                                   " | Cedula: " + rs.getString("num_cedula") +
                                   " | Apellido P: " + rs.getString("apellidop"));
            }
        } catch (SQLException e) {
            System.out.println("Error al leer doctores: " + e.getMessage());
        }
    }

    // UPDATE (Actualizar) =========================================================
    public static void actualizarDoctor(Doctor doctor) {
        String sql = "UPDATE doctor SET nombre_doctor = ?, num_cedula = ?, apellidop = ? WHERE id_doctor = ?";
        try (Connection conn = estadoConeccion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, doctor.getNombreDoctor());
            pstmt.setString(2, doctor.getNumCedula());
            pstmt.setString(3, doctor.getApellidoP());
            pstmt.setInt(4, doctor.getIdDoctor());
            pstmt.executeUpdate();
            System.out.println("Doctor actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar doctor: " + e.getMessage());
        }
    }

    // DELETE (Eliminar) =========================================================
    public static void eliminarDoctor(int idDoctor) {
        String sql = "DELETE FROM doctor WHERE id_doctor = ?";
        try (Connection conn = estadoConeccion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idDoctor);
            pstmt.executeUpdate();
            System.out.println("Doctor eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar doctor: " + e.getMessage());
        }
    }

    // Devuelve el id de un doctor existente (el primero que encuentre), o si no
    // hay ninguno, crea uno generico ("Doctor General") y devuelve su id.
    // Se usa porque el formulario no pide doctor, pero consultas.id_doctor es NOT NULL.
    public static int obtenerOCrearDoctorPorDefecto() {
        String buscar = "SELECT id_doctor FROM doctor ORDER BY id_doctor LIMIT 1";
        try (Connection conn = estadoConeccion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(buscar)) {
            if (rs.next()) {
                return rs.getInt("id_doctor");
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar doctor por defecto: " + e.getMessage());
            return -1;
        }

        String crear = "INSERT INTO doctor (nombre_doctor, num_cedula, apellidop) "
                     + "VALUES ('Doctor', 'SIN-CEDULA', 'General') RETURNING id_doctor";
        try (Connection conn = estadoConeccion();
             PreparedStatement pstmt = conn.prepareStatement(crear);
             ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("id_doctor");
            }
            return -1;
        } catch (SQLException e) {
            System.out.println("Error al crear doctor por defecto: " + e.getMessage());
            return -1;
        }
    }


    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~ CONSULTA ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // CREATE (Insertar) =========================================================
    public static void insertarConsulta(Consulta consulta) {
        String sql = "INSERT INTO consultas (alergias, observaciones_sintomas, diagnostico, "
                   + "fecha_registro, id_paciente, id_doctor) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = estadoConeccion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, consulta.getAlergias());
            pstmt.setString(2, consulta.getObservacionesSintomas());
            pstmt.setString(3, consulta.getDiagnostico());
            pstmt.setTimestamp(4, consulta.getFechaRegistro());
            pstmt.setInt(5, consulta.getIdPaciente());
            pstmt.setInt(6, consulta.getIdDoctor());
            pstmt.executeUpdate();
            System.out.println("Consulta insertada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar consulta: " + e.getMessage());
        }
    }

    // REGRESAR =========================================================
    public static void leerConsulta() {
        String sql = "SELECT id_consulta, alergias, observaciones_sintomas, diagnostico, "
                   + "fecha_registro, id_paciente, id_doctor FROM consultas";
        try (Connection conn = estadoConeccion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_consulta") +
                                   " | Alergias: " + rs.getString("alergias") +
                                   " | Sintomas: " + rs.getString("observaciones_sintomas") +
                                   " | Diagnostico: " + rs.getString("diagnostico") +
                                   " | Fecha: " + rs.getTimestamp("fecha_registro") +
                                   " | ID Paciente: " + rs.getInt("id_paciente") +
                                   " | ID Doctor: " + rs.getInt("id_doctor"));
            }
        } catch (SQLException e) {
            System.out.println("Error al leer consultas: " + e.getMessage());
        }
    }

    // UPDATE (Actualizar) =========================================================
    public static void actualizarConsulta(Consulta consulta) {
        String sql = "UPDATE consultas SET alergias = ?, observaciones_sintomas = ?, diagnostico = ?, "
                   + "id_paciente = ?, id_doctor = ? WHERE id_consulta = ?";
        try (Connection conn = estadoConeccion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, consulta.getAlergias());
            pstmt.setString(2, consulta.getObservacionesSintomas());
            pstmt.setString(3, consulta.getDiagnostico());
            pstmt.setInt(4, consulta.getIdPaciente());
            pstmt.setInt(5, consulta.getIdDoctor());
            pstmt.setInt(6, consulta.getIdConsulta());
            pstmt.executeUpdate();
            System.out.println("Consulta actualizada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar consulta: " + e.getMessage());
        }
    }

    // DELETE (Eliminar) =========================================================
    public static void eliminarConsulta(int idConsulta) {
        String sql = "DELETE FROM consultas WHERE id_consulta = ?";
        try (Connection conn = estadoConeccion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idConsulta);
            pstmt.executeUpdate();
            System.out.println("Consulta eliminada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar consulta: " + e.getMessage());
        }
    }


    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~ EGRESO ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // CREATE (Insertar) =========================================================
    public static void insertarEgreso(Egreso egreso) {
        String sql = "INSERT INTO egresos (observaciones_egreso, fecha_registro, id_paciente, hora_salida) "
                   + "VALUES (?, ?, ?, ?)";
        try (Connection conn = estadoConeccion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, egreso.getObservacionesEgreso());
            pstmt.setTimestamp(2, egreso.getFechaRegistro());
            pstmt.setInt(3, egreso.getIdPaciente());
            pstmt.setTime(4, egreso.getHoraSalida());
            pstmt.executeUpdate();
            System.out.println("Egreso insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar egreso: " + e.getMessage());
        }
    }

    // REGRESAR =========================================================
    public static void leerEgreso() {
        String sql = "SELECT id_egreso, observaciones_egreso, fecha_registro, id_paciente, hora_salida "
                   + "FROM egresos";
        try (Connection conn = estadoConeccion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_egreso") +
                                   " | Observaciones: " + rs.getString("observaciones_egreso") +
                                   " | Fecha: " + rs.getTimestamp("fecha_registro") +
                                   " | ID Paciente: " + rs.getInt("id_paciente") +
                                   " | Hora Salida: " + rs.getTime("hora_salida"));
            }
        } catch (SQLException e) {
            System.out.println("Error al leer egresos: " + e.getMessage());
        }
    }

    // UPDATE (Actualizar) =========================================================
    public static void actualizarEgreso(Egreso egreso) {
        String sql = "UPDATE egresos SET observaciones_egreso = ?, id_paciente = ?, hora_salida = ? "
                   + "WHERE id_egreso = ?";
        try (Connection conn = estadoConeccion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, egreso.getObservacionesEgreso());
            pstmt.setInt(2, egreso.getIdPaciente());
            pstmt.setTime(3, egreso.getHoraSalida());
            pstmt.setInt(4, egreso.getIdEgreso());
            pstmt.executeUpdate();
            System.out.println("Egreso actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar egreso: " + e.getMessage());
        }
    }

    // DELETE (Eliminar) =========================================================
    public static void eliminarEgreso(int idEgreso) {
        String sql = "DELETE FROM egresos WHERE id_egreso = ?";
        try (Connection conn = estadoConeccion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idEgreso);
            pstmt.executeUpdate();
            System.out.println("Egreso eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar egreso: " + e.getMessage());
        }
    }


    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~ RECETA ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // CREATE (Insertar) =========================================================
  public static int insertarReceta(Receta receta) {
    String sql = "INSERT INTO recetas (fecha_emision, indicaciones_generales, id_consulta) "
               + "VALUES (?, ?, ?) RETURNING id_receta";
    try (Connection conn = estadoConeccion();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setTimestamp(1, receta.getFechaEmision());
        pstmt.setString(2, receta.getIndicacionesGenerales());
        pstmt.setInt(3, receta.getIdConsulta());

        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                System.out.println("Receta insertada correctamente.");
                return rs.getInt("id_receta");
            }
        }
        return -1;
    } catch (SQLException e) {
        System.out.println("Error al insertar receta: " + e.getMessage());
        return -1;
    }
}

    // REGRESAR =========================================================
    public static void leerReceta() {
        String sql = "SELECT id_receta, fecha_emision, indicaciones_generales, id_consulta FROM recetas";
        try (Connection conn = estadoConeccion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_receta") +
                                   " | Fecha Emision: " + rs.getTimestamp("fecha_emision") +
                                   " | Indicaciones: " + rs.getString("indicaciones_generales") +
                                   " | ID Consulta: " + rs.getInt("id_consulta"));
            }
        } catch (SQLException e) {
            System.out.println("Error al leer recetas: " + e.getMessage());
        }
    }

    // UPDATE (Actualizar) =========================================================
    public static void actualizarReceta(Receta receta) {
        String sql = "UPDATE recetas SET fecha_emision = ?, indicaciones_generales = ?, id_consulta = ? "
                   + "WHERE id_receta = ?";
        try (Connection conn = estadoConeccion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setTimestamp(1, receta.getFechaEmision());
            pstmt.setString(2, receta.getIndicacionesGenerales());
            pstmt.setInt(3, receta.getIdConsulta());
            pstmt.setInt(4, receta.getIdReceta());
            pstmt.executeUpdate();
            System.out.println("Receta actualizada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar receta: " + e.getMessage());
        }
    }

    // DELETE (Eliminar) =========================================================
    public static void eliminarReceta(int idReceta) {
        String sql = "DELETE FROM recetas WHERE id_receta = ?";
        try (Connection conn = estadoConeccion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idReceta);
            pstmt.executeUpdate();
            System.out.println("Receta eliminada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar receta: " + e.getMessage());
        }
    }


    // Devuelve el id de la consulta mas reciente de un paciente, o -1 si no tiene ninguna
    public static int obtenerUltimaConsultaId(int idPaciente) {
        String sql = "SELECT id_consulta FROM consultas WHERE id_paciente = ? ORDER BY id_consulta DESC LIMIT 1";
        try (Connection conn = estadoConeccion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idPaciente);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id_consulta");
                }
            }
            return -1;
        } catch (SQLException e) {
            System.out.println("Error al buscar consulta: " + e.getMessage());
            return -1;
        }
    }
    
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~ DETALLE_RECETA ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // CREATE (Insertar) =========================================================
    public static void insertarDetalleReceta(DetalleReceta detalle) {
        String sql = "INSERT INTO detalle_receta (id_receta, medicamento_nombre, dosis, frecuencia, "
                   + "via_administracion, duracion) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = estadoConeccion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, detalle.getIdReceta());
            pstmt.setString(2, detalle.getMedicamentoNombre());
            pstmt.setString(3, detalle.getDosis());
            pstmt.setString(4, detalle.getFrecuencia());
            pstmt.setString(5, detalle.getViaAdministracion());
            pstmt.setString(6, detalle.getDuracion());
            pstmt.executeUpdate();
            System.out.println("Detalle de receta insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar detalle de receta: " + e.getMessage());
        }
    }

    // REGRESAR =========================================================
    public static void leerDetalleReceta() {
        String sql = "SELECT id_receta, medicamento_nombre, dosis, frecuencia, via_administracion, duracion "
                   + "FROM detalle_receta";
        try (Connection conn = estadoConeccion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID Receta: " + rs.getInt("id_receta") +
                                   " | Medicamento: " + rs.getString("medicamento_nombre") +
                                   " | Dosis: " + rs.getString("dosis") +
                                   " | Frecuencia: " + rs.getString("frecuencia") +
                                   " | Via: " + rs.getString("via_administracion") +
                                   " | Duracion: " + rs.getString("duracion"));
            }
        } catch (SQLException e) {
            System.out.println("Error al leer detalle de receta: " + e.getMessage());
        }
    }

    // UPDATE (Actualizar) =========================================================
    public static void actualizarDetalleReceta(DetalleReceta detalle) {
        String sql = "UPDATE detalle_receta SET medicamento_nombre = ?, dosis = ?, frecuencia = ?, "
                   + "via_administracion = ?, duracion = ? WHERE id_receta = ?";
        try (Connection conn = estadoConeccion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, detalle.getMedicamentoNombre());
            pstmt.setString(2, detalle.getDosis());
            pstmt.setString(3, detalle.getFrecuencia());
            pstmt.setString(4, detalle.getViaAdministracion());
            pstmt.setString(5, detalle.getDuracion());
            pstmt.setInt(6, detalle.getIdReceta());
            pstmt.executeUpdate();
            System.out.println("Detalle de receta actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar detalle de receta: " + e.getMessage());
        }
    }

    // DELETE (Eliminar) =========================================================
    public static void eliminarDetalleReceta(int idReceta) {
        String sql = "DELETE FROM detalle_receta WHERE id_receta = ?";
        try (Connection conn = estadoConeccion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idReceta);
            pstmt.executeUpdate();
            System.out.println("Detalle de receta eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar detalle de receta: " + e.getMessage());
        }
    }
}
