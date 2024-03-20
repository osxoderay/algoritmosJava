package org.od.ejercicio2;

import java.util.Random;

public class Ejercicio2 {

    /**
     * Metodo que genera personas con genero y edad de manera aleatorio
     * @param personas donde se guardaran las personas con genero y edad
     */
    public static void generarDatos(Persona[] personas) {
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            personas[i] = new Persona();
            // Genera un genero aleatorio
            personas[i].genero = random.nextBoolean() ? 'M' : 'F';
            // Genera una edad aleatoria entre 0 y 99
            personas[i].edad = random.nextInt(100);
        }
    }

    /**
     * Metodo que lee las personas creadas y hace la clasificación
     * @param personas donde se guardaran las personas con genero y edad
     */
    public static void leerPersonas(Persona[] personas) {
        System.out.println("-- ALGORITMO CLASIFICACIÓN DE 50 PERSONAS SEGUN EDAD Y SEXO -- ");
        System.out.println("Lista de personas :");
        for (int i = 0; i < personas.length; i++) {
            System.out.println("Persona nº" + (i + 1) + ": Género: " + personas[i].genero + ", Edad: " + personas[i].edad);
        }

        int mayoresDeEdad = 0;
        int menoresDeEdad = 0;
        int hombresMayores = 0;
        int mujeresMenores = 0;
        int totalMujeres = 0;

        for (Persona persona : personas) {
            if (persona.edad >= 18) {
                mayoresDeEdad++;
                if (persona.genero == 'M') {
                    hombresMayores++;
                }
            } else {
                menoresDeEdad++;
                if (persona.genero == 'F') {
                    mujeresMenores++;
                }
            }
            if (persona.genero == 'F') {
                totalMujeres++;
            }
        }


        double porcentajeMayores = ((double) mayoresDeEdad / personas.length) * 100;
        double porcentajeMujeres = ((double) totalMujeres / personas.length) * 100;

        System.out.println(" - CLASIFICACION -");
        System.out.println("Cantidad de personas mayores de edad: " + mayoresDeEdad);
        System.out.println("Cantidad de personas menores de edad: " + menoresDeEdad);
        System.out.println("Cantidad de personas masculinas mayores de edad: " + hombresMayores);
        System.out.println("Cantidad de personas femeninas menores de edad: " + mujeresMenores);
        System.out.println("Porcentaje que representan las personas mayores de edad: " + porcentajeMayores + "%");
        System.out.println("Porcentaje que representan las mujeres: " + porcentajeMujeres + "%");
    }
    public static void main(String[] args) {

        Persona[] personas = new Persona[50];
        generarDatos(personas);
        leerPersonas(personas);
    }


}