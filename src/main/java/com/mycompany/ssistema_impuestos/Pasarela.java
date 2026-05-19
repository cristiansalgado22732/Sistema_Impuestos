package com.mycompany.ssistema_impuestos;

public class Pasarela {
    private String nombreBanco;

    public Pasarela(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public boolean validarPago(Pago pago) {
        System.out.println("[" + nombreBanco + "] Validando pago de $" + pago.getMonto() + "...");
        // Lógica de validación: monto debe ser mayor a 0
        boolean esValido = pago.getMonto() > 0;
        System.out.println("[" + nombreBanco + "] Pago " + (esValido ? "valido" : "invalido") + ".");
        return esValido;
    }

    public boolean procesarTransaccion(Pago pago) {
        System.out.println("[" + nombreBanco + "] Procesando transaccion de $" + pago.getMonto() + " por " + pago.getMetodo() + "...");
        // Simulación de transacción exitosa
        System.out.println("[" + nombreBanco + "] Transaccion completada.");
        return true;
    }

    // Getters y Setters
    public String getNombreBanco() { return nombreBanco; }
    public void setNombreBanco(String nombreBanco) { this.nombreBanco = nombreBanco; }
}
