/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.Date;

/**
 *
 * @author omara
 */
public class Pagos {

    private Reservas reserva;
    private Date fechaPago;
    private double montoPagado;

    public Pagos(Reservas reserva, Date fechaPago, double montoPagado) {
        this.reserva = reserva;
        this.fechaPago = fechaPago;
        this.montoPagado = montoPagado;
    }

}
