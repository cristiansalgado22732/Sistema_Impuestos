package com.mycompany.ssistema_impuestos;
import Sistema_Impuestos.src.main.java.com.mycompany.ssistema_impuestos.Pasarela;

public class Pago {
     private int id;
    private double monto;
    private String metodo;
    private String estado;
    private Pasarela pasarela;

    public Pago(int id, double monto, String metodo, String estado) {
        this.id = id;
        this.monto = monto;
        this.metodo = metodo;
        this.estado = estado;
    }

    public void procesarPago(Pasarela pasarela) {
        this.pasarela = pasarela;
        System.out.println("Procesando pago ID " + id + " de $" + monto + " mediante " + metodo + "...");
        boolean valido = pasarela.validarPago(this);
        if (valido) {
            boolean resultado = pasarela.procesarTransaccion(this);
            if (resultado) {
                this.estado = "PROCESADO";
                System.out.println("Pago procesado exitosamente.");
            } else {
                this.estado = "FALLIDO";
                System.out.println("Error al procesar el pago.");
            }
        } else {
            this.estado = "INVALIDO";
            System.out.println("Pago inválido, no se procesó.");
        }
    }

    public void confirmarPago() {
        if ("PROCESADO".equals(this.estado)) {
            System.out.println("Pago ID " + id + " confirmado.");
        } else {
            System.out.println("No se puede confirmar un pago en estado: " + estado);
        }
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }

    public String getMetodo() { return metodo; }
    public void setMetodo(String metodo) { this.metodo = metodo; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Pasarela getPasarela() { return pasarela; }
    public void setPasarela(Pasarela pasarela) { this.pasarela = pasarela; }

    @Override
    public String toString() {
        return "Pago{id=" + id + ", monto=" + monto + ", metodo='" + metodo + "', estado='" + estado + "'}";
    }
}
