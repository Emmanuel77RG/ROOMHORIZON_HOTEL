/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author omara
 */
public class HabitacionDAO {
    private Connection conectionDB;
    
    public HabitacionDAO() throws SQLException{
        this.conectionDB=ConexionBaseDatos.getConexion();
    }
    public void crearHabitacion(String numeroHabitacion,String tipoHabitacion,int capacidad,double tarifa,String estadoHabitacion,String detallesHabitacion){
        String query = "Insert Into hotel.habitaciones(Numero_habitacion,Tipo_habitacion,Capacidad,Tarifa_habitacion,Estado_habitacion,Detalles_habitacion)Values(?,?,?,?,?,?)";
        try {
            PreparedStatement statement=conectionDB.prepareStatement(query);
            statement.setString(1, numeroHabitacion);
            statement.setString(2, tipoHabitacion);
            statement.setInt(3, capacidad);
            statement.setDouble(4, tarifa);
            statement.setString(5, estadoHabitacion);
            statement.setString(6, detallesHabitacion);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HabitacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modificarHabitacion(int idHabitacion){
        String query=("Delete from hotel.habitaciones where Id_habitacion=?");
    }
    public ResultSet obtenerDatosHabitaciones()throws SQLException{
        String query=("Select * from hotel.habitaciones");
        PreparedStatement statement=conectionDB.prepareStatement(query);
        return statement.executeQuery();
        
    }
    
    public ResultSet obtenerTiposHabitacion() throws SQLException{
        String query="select Tipo_habitacion from hotel.habitaciones group by Tipo_habitacion";
        PreparedStatement statement=conectionDB.prepareStatement(query);
        return statement.executeQuery();
    }
    
    public void actualizarHabitacion(int capacidad,double tarifa,String estadoHab,String detalleshab,int idHab,String numeroHab) throws SQLException{
        String query="Update hotel.habitaciones set Capacidad=?,Tarifa_habitacion=?,Estado_habitacion=?,Detalles_habitacion=? where Id_habitacion=? and Numero_habitacion=?";
        PreparedStatement statement=conectionDB.prepareStatement(query);
        statement.setInt(1, capacidad);
        statement.setDouble(2, tarifa);
        statement.setString(3, estadoHab);
        statement.setString(4, detalleshab);
        statement.setInt(5, idHab);
        statement.setString(6, numeroHab);
        statement.executeUpdate();
    }
    public void actualizarHabitacion(int capacidad,double tarifa,String estadoHab) throws SQLException{
        String query="Update hotel.habitaciones set Capacidad=?,Tarifa_habitacion=',Estado_habitacion=?";
        PreparedStatement statement=conectionDB.prepareStatement(query);
        statement.executeUpdate();
    }
    public void eliminarHabitacion(int idHabitacion){
        String query=("Delete from hotel.habitaciones where Id_habitacion=?");
        try {
            PreparedStatement statement=conectionDB.prepareStatement(query);
            statement.setInt(1, idHabitacion);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HabitacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    public ResultSet obtenerHabitacionesDisponiblesFechas(String fechaInicio, String fechaFin) throws SQLException {
        String query = "SELECT h.Id_habitacion, h.Numero_habitacion, h.Tipo_habitacion, h.Capacidad, h.Tarifa_habitacion, h.Estado_habitacion, h.Detalles_habitacion\n"
                + "FROM hotel.Habitaciones h\n"
                + "WHERE h.Estado_habitacion = 'Disponible'\n"
                + "AND h.Id_habitacion NOT IN (\n"
                + "    SELECT dr.Id_habitacion\n"
                + "    FROM hotel.Detalles_reserva dr\n"
                + "    INNER JOIN hotel.Reservas r ON dr.Id_reserva = r.Id_reserva\n"
                + "    WHERE r.Fecha_entrada <= ? AND r.Fecha_salida > ?);";

        PreparedStatement statement=conectionDB.prepareStatement(query);
        statement.setString(1, fechaInicio);
        statement.setString(2, fechaFin);
        return statement.executeQuery();
        
    }
    public ResultSet habitacionesDisponiblesNumeroHab(String numeroHab) throws SQLException{
        String query="Select * from hotel.habitaciones where Numero_habitacion=?";
        PreparedStatement statement=conectionDB.prepareStatement(query);
        statement.setString(1, numeroHab);
        return statement.executeQuery();
    }
    public ResultSet habitacionesDisponiblesTipo(String tipoHab) throws SQLException{
        String query="Select * from hotel.habitaciones where Tipo_habitacion=? and Estado_habitacion='Disponible'";
        PreparedStatement statement=conectionDB.prepareStatement(query);
        statement.setString(1, tipoHab);
        return statement.executeQuery();
    }
    
}
