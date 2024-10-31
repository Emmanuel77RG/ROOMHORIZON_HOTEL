/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import conexion.HabitacionDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Habitacion {
    // Atributos correspondientes a las columnas de la tabla SQL
    private int idHabitacion;
    private String numeroHabitacion;
    private String tipoHabitacion;
    private int capacidad;
    private double tarifaHabitacion;
    private String estadoHabitacion;
    private String detallesHabitacion;

    

    // Constructor con todos los atributos
    public Habitacion(int idHabitacion, String numeroHabitacion, String tipoHabitacion, int capacidad, double tarifaHabitacion, String estadoHabitacion, String detallesHabitacion) {
        this.idHabitacion = idHabitacion;
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.capacidad = capacidad;
        this.tarifaHabitacion = tarifaHabitacion;
        this.estadoHabitacion = estadoHabitacion;
        this.detallesHabitacion = detallesHabitacion;
    }

    public Habitacion(int idHabitacion, String numeroHabitacion, String tipoHabitacion, double tarifaHabitacion) {
        this.idHabitacion = idHabitacion;
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.tarifaHabitacion = tarifaHabitacion;
    }

    public Habitacion(int idHabitacion, String numeroHabitacion, String tipoHabitacion) {
        this.idHabitacion = idHabitacion;
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
    }
    
    

    // Getters y Setters
    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(String numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getTarifaHabitacion() {
        return tarifaHabitacion;
    }

    public void setTarifaHabitacion(double tarifaHabitacion) {
        this.tarifaHabitacion = tarifaHabitacion;
    }

    public String getEstadoHabitacion() {
        return estadoHabitacion;
    }

    public void setEstadoHabitacion(String estadoHabitacion) {
        this.estadoHabitacion = estadoHabitacion;
    }

    public String getDetallesHabitacion() {
        return detallesHabitacion;
    }

    public void setDetallesHabitacion(String detallesHabitacion) {
        this.detallesHabitacion = detallesHabitacion;
    }

    
    public void guardarHabitacionEnBaseDeDatos() throws SQLException {
        HabitacionDAO habitacionDAO = new HabitacionDAO();
        //habitacionDAO.crearHabitacion(this);
    }

    public void actualizarHabitacionEnBaseDeDatos() throws SQLException {
        HabitacionDAO habitacionDAO = new HabitacionDAO();
        //habitacionDAO.actualizarHabitacion(this);
    }

    // Método estático para eliminar una habitación de la base de datos
    public static void eliminarHabitacionDeBaseDeDatos(int idHabitacion) throws SQLException {
        HabitacionDAO habitacionDAO = new HabitacionDAO();
        habitacionDAO.eliminarHabitacion(idHabitacion);
    }
    
    public static ArrayList<Habitacion> consultarDisponibilidadPorFechas(Date fechaInicio, Date fechaFin) throws SQLException {
        java.sql.Date sqlFechaInicio = new java.sql.Date(fechaInicio.getTime());
        java.sql.Date sqlFechaFin = new java.sql.Date(fechaFin.getTime());

        HabitacionDAO habitacionDAO = new HabitacionDAO();
        return habitacionDAO.obtenerHabitacionesDisponiblesPorFechas(sqlFechaInicio, sqlFechaFin);
    }
    public static ArrayList<Habitacion> consultarDisponibilidadPorNumero(String numeroHab) throws SQLException {
        HabitacionDAO habitacionDAO = new HabitacionDAO();
        return habitacionDAO.habitacionesDisponiblesPorNumeroHab(numeroHab);
    }

    public static ArrayList<Habitacion> consultarDisponibilidadPorTipo(String tipoHab) throws SQLException {
        HabitacionDAO habitacionDAO = new HabitacionDAO();
        return habitacionDAO.habitacionesDisponiblesPorTipo(tipoHab);
    }

    // Method to get all rooms
    public static ArrayList<Habitacion> consultarTodasLasHabitaciones() throws SQLException {
        HabitacionDAO habitacionDAO = new HabitacionDAO();
        return habitacionDAO.obtenerTodasLasHabitaciones();
    }

}
