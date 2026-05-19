/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ssistema_impuestos;
import Sistema_Impuestos.src.main.java.com.mycompany.ssistema_impuestos.Pasarela;

/**
 *
 * @author criss
 */
import java.util.ArrayList;
import java.util.List;

public class Contribuyente extends Usuario {
    private double ingresos;
    private double gastos;
    private double deducciones;
    private List<Declaracion> declaraciones;

    public Contribuyente(int id, String nombre, String apellido, String contraseña, String correo,
                         double ingresos, double gastos, double deducciones) {
        super(id, nombre, apellido, contraseña, correo);
        this.ingresos = ingresos;
        this.gastos = gastos;
        this.deducciones = deducciones;
        this.declaraciones = new ArrayList<>();
    }

    public void registrarInformacionFinanciera(double ingresos, double gastos, double deducciones) {
        this.ingresos = ingresos;
        this.gastos = gastos;
        this.deducciones = deducciones;
        System.out.println("Información financiera registrada.");
    }

    public double calcularImpuestos() {
        double baseImponible = ingresos - gastos - deducciones;
        double impuesto = baseImponible > 0 ? baseImponible * 0.19 : 0;
        System.out.println("Impuesto calculado: $" + impuesto);
        return impuesto;
    }

    public Declaracion generarDeclaracion() {
        double totalImpuesto = calcularImpuestos();
        Declaracion declaracion = new Declaracion(
            declaraciones.size() + 1,
            new java.util.Date(),
            "PENDIENTE",
            totalImpuesto
        );
        declaraciones.add(declaracion);
        System.out.println("Declaración generada con ID: " + declaracion.getId());
        return declaracion;
    }

    public void enviarDeclaracion(Declaracion declaracion) {
        declaracion.enviar();
        System.out.println("Declaración enviada correctamente.");
    }

    public void realizarPago(Declaracion declaracion, String metodoPago, Pasarela pasarela) {
        Pago pago = declaracion.getPago();
        if (pago == null) {
            pago = new Pago(1, declaracion.getTotalImpuesto(), metodoPago, "PENDIENTE");
            declaracion.setPago(pago);
        }
        pago.procesarPago(pasarela);
    }

    // Getters y Setters
    public double getIngresos() { return ingresos; }
    public void setIngresos(double ingresos) { this.ingresos = ingresos; }

    public double getGastos() { return gastos; }
    public void setGastos(double gastos) { this.gastos = gastos; }

    public double getDeducciones() { return deducciones; }
    public void setDeducciones(double deducciones) { this.deducciones = deducciones; }

    //public List<Declaracion> getDeclaraciones() { return declaraciones; }
}
