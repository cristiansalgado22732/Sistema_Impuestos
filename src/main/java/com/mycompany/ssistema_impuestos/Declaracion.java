/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package com.mycompany.ssistema_impuestos;
import java.util.Date;
/**
 *
 * @author estef
 */
public class Declaracion {
    
    private int id;
    private Date fecha;
    private String estado;
    private double totalImpuesto;
    private Pago pago;

    public Declaracion(int id, Date fecha, String estado, double totalImpuesto) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.totalImpuesto = totalImpuesto;
    }

    public void generar() {
        System.out.println("Generando declaracion ID: " + id + " con impuesto total: $" + totalImpuesto);
    }

    public void enviar() {
        if ("PENDIENTE".equals(this.estado)) {
            this.estado = "ENVIADA";
            System.out.println("Declaracion ID " + id + " enviada.");
        } else {
            System.out.println("La declaración no puede enviarse en estado: " + estado);
        }
    }

    public void actualizarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        System.out.println("Estado de declaracion ID " + id + " actualizado a: " + nuevoEstado);
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public double getTotalImpuesto() { return totalImpuesto; }
    public void setTotalImpuesto(double totalImpuesto) { this.totalImpuesto = totalImpuesto; }

    public Pago getPago() {
        return pago; 
    }
    
    public void setPago(Pago pago) {
        this.pago = pago; 
    }

    @Override
    public String toString() {
        return "Declaracion\n Id= " + id + "\n Fecha= " + fecha + "\n Estado= '" + estado + "'\n TotalImpuesto= " + totalImpuesto;
    }
}
