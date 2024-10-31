/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import conexion.ClienteDAO;
import conexion.EmpleadoDAO;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author omara
 */
public class Administrador {
    public void crearEmpleado(String nombre, String apellido, String rol, String password, Date fechaContratacion, String numero,
            String correo) throws SQLException {
        Empleado empleado = new Empleado(nombre, apellido, rol, password, fechaContratacion, numero, correo);
        ClienteDAO clienteDAO = new ClienteDAO();
        //clienteDAO.crearCliente();

    }

    public void crearHabitacion(String numeroHab, String tipoHabitacion, int capacidad,
            double tarifaHabitacion, String estadoHabitacion,
            String detallesHabitacion) throws SQLException {

        // Crear una instancia de Habitacion
        Habitacion nuevaHabitacion = new Habitacion(0, numeroHab, tipoHabitacion, capacidad,
                tarifaHabitacion, estadoHabitacion,
                detallesHabitacion);

        // Invocar el método para guardar la habitación en la base de datos
        nuevaHabitacion.guardarHabitacionEnBaseDeDatos();
    }

    public void modificarHabitacion(int idHabitacion, int capacidad, double tarifa, String estado, String detalles) throws SQLException {

        // Crear instancia de Habitacion con los nuevos datos
        Habitacion habitacionModificada = new Habitacion(idHabitacion, "", "", capacidad, tarifa, estado, detalles);

        // Llamar al método para actualizar la habitación en la base de datos
        habitacionModificada.actualizarHabitacionEnBaseDeDatos();
    }

    // Método para eliminar una habitación
    public void eliminarHabitacion(int idHabitacion) throws SQLException {
        // Llamar al método para eliminar la habitación en la base de datos
        Habitacion.eliminarHabitacionDeBaseDeDatos(idHabitacion);
    }

    public void eliminarEmpleado(int idEmpleado) throws SQLException {
        // Permission check

        // Use EmpleadoDAO to delete the employee from the database
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        empleadoDAO.eliminarEmpleadoPorId(idEmpleado);
    }

    public void modificarEmpleado(int idEmpleado, String nombre, String apellido, String rol, String contrasena, String correo, String telefono) throws SQLException {

        // Create an Empleado object with the updated data
        Empleado empleadoAModificar = new Empleado(idEmpleado, nombre, apellido, rol, correo, contrasena, telefono);

        // Use EmpleadoDAO to update the employee in the database
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        //empleadoDAO.modificarDatosEmpleado(empleadoAModificar);
    }
}
