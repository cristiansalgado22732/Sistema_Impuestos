/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ssistema_impuestos;

/**
 *
 * @author estef
 */
public class Administrador extends Usuario {
    private String rol;

    public Administrador(int id, String nombre, String apellido, String contraseña, String correo, String rol) {
        super(id, nombre, apellido, contraseña, correo);
        this.rol = rol;
    }

    public void gestionarDeclaraciones() {
        System.out.println("Administrador " + getNombre() + " gestionando declaraciones...");
    }

    public void aprobarDeclaracion(Declaracion declaracion) {
        declaracion.actualizarEstado("APROBADA");
        System.out.println("Declaracion ID " + declaracion.getId() + " aprobada.");
    }

    public void rechazarDeclaracion(Declaracion declaracion) {
        declaracion.actualizarEstado("RECHAZADA");
        System.out.println("Declaracion ID " + declaracion.getId() + " rechazada.");
    }

    // Getters y Setters
    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
}
    

