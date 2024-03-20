package org.od;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio1 {

    /**
     * Metodo que se encarga de pedirle un numero entero al usuario
     * y si no es válido le salta un error hasta que escriba un numero válido.
     * @return devuelve el numero que ha escrito el usuario
     */
    public static int leerNumero() {
        System.out.println("-- ALGORITMO NUMERO PAR O IMPAR --");

        Scanner sc = new Scanner(System.in);
        int numero = 0;
        boolean esNumero = false;

        // bucle while que se encarga de solicitar al usuario que ingrese un número válido.
        while (!esNumero) {
            try {
                System.out.print("Escriba un número entero y le indicará si es par o impar: " + "\n");
                numero = sc.nextInt();
                esNumero = true;
            } catch (InputMismatchException e) {
                System.out.println("Error! Número entero inválido. No se admite texto.");
                sc.next();
            }
        }

        return numero;
    }

    /**
     * Metodo que se encarga de indicar si el numero es par o impar. Si es par,
     * escribe todos los pares de manera descendiente desde sí mismo y hasta el cero. Si
     * es impar, escribe todos los impares de manera descendiente desde si sí mismo
     * hasta el uno.
     * @param numero numero que ha introducido el usuario en el metodo leerNumero()
     */
    public static void decirSiParImparDescendente(int numero) {
        if (numero % 2 == 0) {
            System.out.println("El número es par.");
            for (int i = numero; i >= 0; i -= 2) {
                System.out.print(i + " ");
            }
        } else {
            System.out.println("El número es impar.");
            for (int i = numero; i >= 1; i -= 2) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        int numero = leerNumero();
        decirSiParImparDescendente(numero);
    }
}