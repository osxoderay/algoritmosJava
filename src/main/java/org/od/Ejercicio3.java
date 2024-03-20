package org.od;

import java.util.Scanner;

public class Ejercicio3 {
    /**
     * Metodo que pide al usuario las horas que ha trabajado
     * @return devuelve las horas trabajadas del usuario
     */
    public static int pedirHorasTrabajadas() {
        Scanner scanner = new Scanner(System.in);
        int horasTrabajadas;
        while (true) {
            System.out.print("Escriba las horas que ha trabajado: " + "\n");
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número entero válido para las horas trabajadas.");
                scanner.next();
                System.out.print("Escriba las horas que ha trabajado: ");
            }
            horasTrabajadas = scanner.nextInt();
            if (horasTrabajadas < 0) {
                System.out.println("El número de horas trabajadas no puede ser negativo. Por favor, inténtelo de nuevo.");
            } else {
                break;
            }
        }
        return horasTrabajadas;
    }

    /**
     * Metodo que pide al usuario la tarifa por hora
     * @return devuelve la tarifa por hora del usuario
     */
    public static double pedirTarifaPorHora() {
        Scanner scanner = new Scanner(System.in);
        double tarifaPorHora;
        while (true) {
            System.out.print("Escriba la tarifa por hora: " + "\n");
            while (!scanner.hasNextDouble()) {
                System.out.println("Por favor, ingrese un número válido para la tarifa por hora.");
                scanner.next();
                System.out.print("Escriba la tarifa por hora: ");
            }
            tarifaPorHora = scanner.nextDouble();
            if (tarifaPorHora < 0) {
                System.out.println("La tarifa por hora no puede ser un número negativo. Por favor, inténtelo de nuevo.");
            } else {
                break;
            }
        }
        return tarifaPorHora;
    }
    public static double calcularSueldo(int horasTrabajadas, double tarifaPorHora) {

        double sueldo = 0;
        if (horasTrabajadas > 40) {
            int horasNormales = 40;
            int horasExtras = horasTrabajadas - 40;
            sueldo = (horasNormales * tarifaPorHora) + (horasExtras * (tarifaPorHora * 1.5));
        } else {
            sueldo = horasTrabajadas * tarifaPorHora;
        }

        return sueldo;
    }

    public static double obtenerSalario() {

        System.out.println("-- ALGORITMO CALCULO DEL SALARIO DEL TRABAJADOR -- ");
        int horasTrabajadas = pedirHorasTrabajadas();
        double tarifaPorHora = pedirTarifaPorHora();

        try {
            return calcularSueldo(horasTrabajadas, tarifaPorHora);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }

    public static void main(String[] args) {

        double sueldo = obtenerSalario();
        System.out.println("El salario recibido por el trabajador es: " + sueldo);
    }

}
