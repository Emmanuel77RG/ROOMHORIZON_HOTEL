/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import conexion.ReservasDAO;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Reservas {
    private Habitacion habitacion;
    private Cliente cliente;
    private Empleado empleado;
    private int idReserva;
    private Date fechaEntrada;
    private Date fechaSalida;
    private String horaEntrada;
    private String horaSalida;
    private String estadoReserva;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private int cantidadPersonas;
    private String notas;
    private ArrayList<Reservas> listaReservas;

    public Reservas(Habitacion habitacion, Cliente cliente, Empleado empleado, Date fechaEntrada, Date fechaSalida, String estadoReserva, int cantidadPersonas, String notas) {
        this.habitacion = habitacion;
        this.cliente = cliente;
        this.empleado = empleado;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.estadoReserva = estadoReserva;
        this.cantidadPersonas = cantidadPersonas;
        this.notas = notas;
        listaReservas=new ArrayList<>();

    }

    public Reservas(Habitacion habitacion, Cliente cliente, Empleado empleado, int idReserva, Date fechaEntrada, Date fechaSalida, String estadoReserva, int cantidadPersonas, String notas) {
        this.habitacion = habitacion;
        this.cliente = cliente;
        this.empleado = empleado;
        this.idReserva = idReserva;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.estadoReserva = estadoReserva;
        this.cantidadPersonas = cantidadPersonas;
        this.notas = notas;

    }

    public Reservas(Habitacion habitacion, Cliente cliente, Empleado empleado, int idReserva, Date fechaEntrada, Date fechaSalida, int cantidadPersonas, String notas) {
        this.habitacion = habitacion;
        this.cliente = cliente;
        this.empleado = empleado;
        this.idReserva = idReserva;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.cantidadPersonas = cantidadPersonas;
        this.notas = notas;
        listaReservas=new ArrayList<>();

    }

    public Reservas(Habitacion habitacion, Cliente cliente, Empleado empleado, int idReserva, Date fechaEntrada, Date fechaSalida, String horaEntrada, String horaSalida, String estadoReserva,Date fechaCreacion, Date fechaModificacion, int cantidadPersonas, String notas) {
        this.habitacion = habitacion;
        this.cliente = cliente;
        this.empleado = empleado;
        this.idReserva = idReserva;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.estadoReserva = estadoReserva;
        this.fechaCreacion=fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.cantidadPersonas = cantidadPersonas;
        this.notas = notas;
    }
    
    public Reservas(){

    }
    

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    

    public int getIdReserva() {
        return idReserva;
    }
    

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }
   

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }
     public Date getFechaCreacion(){
        return fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public void setListaReservas(ArrayList<Reservas> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public ArrayList<Reservas> getListaReservas() {
        return listaReservas;
    }

    public void agregarAlReservasManager() {
        ReservasManager.getInstance().addReserva(this);
    }

    public void crearReserva() throws SQLException {
        // Logic to create the reservation in the database
        ReservasDAO reservasDAO = new ReservasDAO();

        // Convert dates to the appropriate format
        SimpleDateFormat formatoMySQL = new SimpleDateFormat("yyyy-MM-dd");
        String fechaEntradaMySQL = formatoMySQL.format(this.fechaEntrada);
        String fechaSalidaMySQL = formatoMySQL.format(this.fechaSalida);

        // Create the reservation in the database
        reservasDAO.crearReservaDB(this.cliente.getId_cliente(), this.empleado.getId_empleado(), fechaEntradaMySQL, fechaSalidaMySQL, this.estadoReserva);

        // Get the ID of the newly created reservation
        int idReserva = reservasDAO.obtenerReservaCliente(this.cliente.getId_cliente());
        this.setIdReserva(idReserva);

        // Create reservation details
        reservasDAO.crearReservaDetallesReserva(this.idReserva, this.habitacion.getIdHabitacion(), this.cantidadPersonas, this.notas);

        // Update the status of the room
        reservasDAO.actualizarHabitacion(this.habitacion.getIdHabitacion());
    }

    // Method to modify a reservation
    public void modificarReserva(Habitacion nuevaHabitacion) throws SQLException {
        ReservasDAO reservasDAO = new ReservasDAO();

        // Convert dates to the appropriate format
        SimpleDateFormat formatoMySQL = new SimpleDateFormat("yyyy-MM-dd");
        String fechaEntradaMySQL = formatoMySQL.format(this.fechaEntrada);
        String fechaSalidaMySQL = formatoMySQL.format(this.fechaSalida);
        String fechaHoraActualMySQL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        // Update the reservation
        reservasDAO.modificarReservas(this.idReserva, this.empleado.getId_empleado(), this.estadoReserva, fechaEntradaMySQL, fechaSalidaMySQL, fechaHoraActualMySQL);

        if (nuevaHabitacion != null && nuevaHabitacion.getIdHabitacion() != this.habitacion.getIdHabitacion()) {
            // Modify reservation with room change
            reservasDAO.modificarReservaConCambioDeHabitacion(this.idReserva, this.habitacion.getIdHabitacion(), nuevaHabitacion.getIdHabitacion(), this.cantidadPersonas, this.notas);
            this.habitacion = nuevaHabitacion; // Update the room in the reservation
        } else {
            // Modify reservation without room change
            reservasDAO.modificarReservaSinCambioDeHabitacion(this.idReserva, this.habitacion.getIdHabitacion(), this.cantidadPersonas, this.notas);
        }
    }

    // Method to cancel a reservation
    public void cancelarReserva() throws SQLException {
        ReservasDAO reservasDAO = new ReservasDAO();

        reservasDAO.cancelarReserva(this.habitacion.getIdHabitacion(), this.idReserva, this.cliente.getId_cliente(), this.empleado.getId_empleado());
    }

    public void registrarCheckIn(Time horaEntrada) throws SQLException {
        ReservasDAO reservasDAO = new ReservasDAO();
        //reservasDAO.actualizarReservaClienteCheckIn(this.idReserva, this.cliente.getId_cliente(), horaEntrada);

        // Optionally update the reservation's state
        this.setEstadoReserva("En estancia");
    }

    public static ArrayList<Reservas> obtenerHistorialDeReservas() throws SQLException {
        ReservasDAO reservasDAO = new ReservasDAO();
        return reservasDAO.obtenerHistorialDeReservas();
    }

}

