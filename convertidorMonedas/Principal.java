package com.aluracurses.convertidorMonedas;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public Principal() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        double cantidad, resultado;
        // Ejemplo de tasas de cambio (ficticias)
        double usdToEur = 0.92;
        double eurToUsd = 1.09;
        double usdToMxn = 16.9;
        double mxnToUsd = 0.059;
        double eurToMxn = 18.35;
        double mxnToEur = 0.054;


        do {
            System.out.println("------ Conversor de Monedas ------");
            System.out.println("1. Dólar a Euro");
            System.out.println("2. Euro a Dólar");
            System.out.println("3. Dólar a Peso Mexicano");
            System.out.println("4. Peso Mexicano a Dólar");
            System.out.println("5. Euro a Peso Mexicano");
            System.out.println("6. Peso Mexicano a Euro");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 6) {
                System.out.print("Introduce la cantidad a convertir: ");
                cantidad = scanner.nextDouble();
                switch (opcion) {
                    case 1:
                        double val = 0;
                        try {
                            var miBusqueda=new Busqueda();
                            miBusqueda.setValor("USD", "EUR");
                            val=miBusqueda.getValor();
                        } catch (IOException | InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        resultado = cantidad * val;
                        System.out.printf("%.2f dólares son %.2f euros\n\n", cantidad, resultado);
                        break;
                    case 2:
                        try {
                            var miBusqueda=new Busqueda();
                            miBusqueda.setValor("EUR", "USD");
                            val=miBusqueda.getValor();
                        } catch (IOException | InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        resultado = cantidad * val;
                        System.out.printf("%.2f euros son %.2f dolares\n\n", cantidad, resultado);
                        break;
                    case 3:
                        try {
                            var miBusqueda=new Busqueda();
                            miBusqueda.setValor("USD", "MXN");
                            val=miBusqueda.getValor();
                        } catch (IOException | InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        resultado = cantidad * val;
                        System.out.printf("%.2f dólares son %.2f pesos mexicanos\n\n", cantidad, resultado);
                        break;
                    case 4:
                        try {
                            var miBusqueda=new Busqueda();
                            miBusqueda.setValor("MXN", "USD");
                            val=miBusqueda.getValor();
                        } catch (IOException | InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        resultado = cantidad * val;
                        System.out.printf("%.2f pesos mexicanos son %.2f dolares\n\n", cantidad, resultado);
                        break;
                    case 5:
                        try {
                            var miBusqueda=new Busqueda();
                            miBusqueda.setValor("EUR", "MXN");
                            val=miBusqueda.getValor();
                        } catch (IOException | InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        resultado = cantidad * val;
                        System.out.printf("%.2f euros son %.2f pesos mexicanos\n\n", cantidad, resultado);
                        break;
                    case 6:
                        try {
                            var miBusqueda=new Busqueda();
                            miBusqueda.setValor("MXN", "EUR");
                            val=miBusqueda.getValor();
                        } catch (IOException | InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        resultado = cantidad * val;
                        System.out.printf("%.2f pesos mexicanos son %.2f euros\n\n", cantidad, resultado);
                        break;
                }
            } else if (opcion != 7) {
                System.out.println("Opción no válida, intenta de nuevo.\n");
            }
        } while (opcion != 7);

        System.out.println("¡Gracias por usar el conversor!");
        scanner.close();


    }
}
