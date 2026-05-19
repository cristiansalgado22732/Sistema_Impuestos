/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ssistema_impuestos;

/**
 *
 * @author criss
 */
public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String contraseña;
    private String correo;
 
    public Usuario(int id, String nombre, String apellido, String contraseña, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contraseña = contraseña;
        this.correo = correo;
    }
 
    public void registrar() {
        System.out.println("Usuario registrado: " + nombre + " " + apellido);
    }
 
    public boolean iniciarSesion(String correo, String contraseña) {
        if (this.correo.equals(correo) && this.contraseña.equals(contraseña)) {
            System.out.println("Sesión iniciada correctamente.");
            return true;
        }
        System.out.println("Credenciales incorrectas.");
        return false;
    }
 
    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
 
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
 
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
 
    public String getContraseña() { return contraseña; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }
 
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
}
