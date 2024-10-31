/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import conexion.ClienteDAO;
import conexion.ReservasDAO;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
public class Empleado {
    private int id_empleado;
    private String nombre;
    private String apellido;
    private String rol;
    private String password;
    private Date fechaContratacion;
    private String numeroTelefono;
    private String correo;

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
    public Empleado(int id_empleado, String nombre, String apellido, String correo, String passwrod,String numero, Date fechaContratacion, String rol) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.password=passwrod;
        this.numeroTelefono = numero;
        this.fechaContratacion = fechaContratacion;
        this.rol = rol;
    }

    public Empleado(int id_empleado, String nombre, String apellido, String rol, String correo,String password,String numero) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
        this.correo=correo;
        this.password = password;
        this.numeroTelefono=numero;
    }

    public Empleado(String nombre, String apellido, String rol, String password, Date fechaContratacion, String numeroTelefono, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
        this.password = password;
        this.fechaContratacion = fechaContratacion;
        this.numeroTelefono = numeroTelefono;
        this.correo = correo;
    }
    

    public Empleado(int id_empleado, String nombre, String apellido) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }
    
    
    public void crearCliente(String nombre, String apellido, String correo,
            String numero) throws SQLException {

        // Crear una instancia de Habitacion
        ClienteDAO clienteNuevo = new ClienteDAO();

        // Invocar el método para guardar la habitación en la base de datos
        clienteNuevo.crearCliente(nombre, apellido, numero, correo);
    }
    public ArrayList<Habitacion> consultarDisponibilidad(Date fechaInicio, Date fechaFin) throws SQLException {
        return Habitacion.consultarDisponibilidadPorFechas(fechaInicio, fechaFin);
    }

    // Method to consult availability by room number
    public ArrayList<Habitacion> consultarDisponibilidad(String numeroHab) throws SQLException {
        return Habitacion.consultarDisponibilidadPorNumero(numeroHab);
    }

    // Method to consult availability by room type
    public ArrayList<Habitacion> consultarDisponibilidadPorTipo(String tipoHab) throws SQLException {
        return Habitacion.consultarDisponibilidadPorTipo(tipoHab);
    }

    // Method to get all rooms
    public ArrayList<Habitacion> consultarTodasHabitaciones() throws SQLException {
        return Habitacion.consultarTodasLasHabitaciones();
    }
    public void asignarHabitacionAReserva(Reservas reserva, Habitacion habitacion) throws SQLException {
        if (habitacion.getEstadoHabitacion().equalsIgnoreCase("Ocupada") || habitacion.getEstadoHabitacion().equalsIgnoreCase("En mantenimiento")) {
            throw new IllegalArgumentException("La habitación seleccionada no está disponible.");
        }

 
        reserva.setHabitacion(habitacion);

 
        ReservasDAO reservasDAO = new ReservasDAO();
        //reservasDAO.actualizarReserva(reserva);
    }
    
    public void crearReserva(Reservas reserva) throws SQLException {
        // You might include permission checks or additional logic here
        reserva.crearReserva();
    }

    // Method to modify a reservation
    public void modificarReserva(Reservas reserva, Habitacion nuevaHabitacion) throws SQLException {
        // You might include permission checks or additional logic here
        reserva.modificarReserva(nuevaHabitacion);
    }

    // Method to cancel a reservation
    public void cancelarReserva(Reservas reserva) throws SQLException {
        // You might include permission checks or additional logic here
        reserva.cancelarReserva();
    }
    public void registrarCheckIn(Reservas reserva, Time horaEntrada) throws SQLException {
        reserva.registrarCheckIn(horaEntrada);
    }
    public ArrayList<Reservas> obtenerHistorialDeReservas() throws SQLException {
        return Reservas.obtenerHistorialDeReservas();
    }
    
//    public Empleado obtenerEmpleadoBuscado(ArrayList<Empleado> listaEmpleados){
//        for(Empleado emp: listaEmpleados){
//            if(emp.nombre==)
//        }
//    }
    
    
}
