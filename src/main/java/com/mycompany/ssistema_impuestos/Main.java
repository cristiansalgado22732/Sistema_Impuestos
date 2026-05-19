/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ssistema_impuestos;
/**
 *
 * @author criss
 */
public class Main {

    public static void main(String[] args) {  
        System.out.println("===== SISTEMA DE DECLARACION DE IMPUESTOS =====\n");

        // 1. Crear pasarela de pago
        Pasarela pasarela = new Pasarela("Banco Nacional");

        // 2. Crear un Administrador
        Administrador admin = new Administrador(1, "Carlos", "Perez", "admin123", "admin@impuestos.gov", "SUPERADMIN");
        admin.registrar();
        admin.iniciarSesion("admin@impuestos.gov", "admin123");

        System.out.println();

        // 3. Crear un Contribuyente
        Contribuyente contribuyente = new Contribuyente(
            2, "Laura", "Gomez", "pass456", "laura@email.com",
            50_000_000, 10_000_000, 5_000_000
        );
        contribuyente.registrar();
        contribuyente.iniciarSesion("laura@email.com", "pass456");

        System.out.println();

        // 4. Registrar información financiera
        contribuyente.registrarInformacionFinanciera(50000000, 10000000, 5000000);

        System.out.println();

        // 5. Generar y enviar declaración
        Declaracion declaracion = contribuyente.generarDeclaracion();
        System.out.println("Declaracion: " + declaracion);
        contribuyente.enviarDeclaracion(declaracion);

        System.out.println();

        // 6. Administrador aprueba la declaración
        admin.gestionarDeclaraciones();
        admin.aprobarDeclaracion(declaracion);

        System.out.println();

        // 7. Contribuyente realiza el pago
        contribuyente.realizarPago(declaracion, "Transferencia Bancaria", pasarela);

        System.out.println();

        // 8. Confirmar pago
        if (declaracion.getPago() != null) {
            declaracion.getPago().confirmarPago();
        }

        System.out.println("\n===== FIN DEL PROCESO =====");
    }
}
