// CajeroAutomatico.java
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Locale; // Para asegurar el uso del punto decimal

public class CajeroAutomatico {

    public static void main(String[] args) {
        // Saldo inicial inferido por Java (será double)
        var saldo = 1000.0;
        int opcion;

        // Usar Locale.US para que el Scanner interprete el punto como separador decimal
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("¡Bienvenido al Cajero Automático!");

        // Bucle principal del cajero, se repite hasta que el usuario elija salir (opción 4)
        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Salir");
            System.out.print("Por favor, seleccione una opción: ");

            try {
                opcion = scanner.nextInt(); // Leer la opción del usuario

                // Switch para manejar la opción seleccionada
                switch (opcion) {
                    case 1:
                        // Consultar saldo
                        System.out.println("------------------------------------");
                        System.out.printf(Locale.US, "Su saldo actual es: $%.2f%n", saldo);
                        System.out.println("------------------------------------");
                        break; // Salir del switch

                    case 2:
                        // Depositar dinero
                        System.out.print("Ingrese la cantidad a depositar: $");
                        try {
                            double montoDeposito = scanner.nextDouble();
                            if (montoDeposito <= 0) {
                                System.out.println("Monto inválido. Por favor, ingrese un valor positivo.");
                            } else {
                                saldo += montoDeposito; // Sumar el monto al saldo
                                System.out.println("------------------------------------");
                                System.out.printf(Locale.US, "Depósito exitoso. Su nuevo saldo es: $%.2f%n", saldo);
                                System.out.println("------------------------------------");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Entrada inválida. Por favor, ingrese un número.");
                            scanner.next(); // Limpiar el buffer del scanner
                        }
                        break; // Salir del switch

                    case 3:
                        // Retirar dinero
                        System.out.print("Ingrese la cantidad a retirar: $");
                        try {
                            double montoRetiro = scanner.nextDouble();
                            if (montoRetiro <= 0) {
                                System.out.println("Monto inválido. Por favor, ingrese un valor positivo.");
                                continue; // Volver al inicio del bucle while (mostrar menú)
                            }
                            if (montoRetiro > saldo) {
                                System.out.println("------------------------------------");
                                System.out.println("Saldo insuficiente para realizar el retiro.");
                                System.out.printf(Locale.US, "Su saldo actual es: $%.2f%n", saldo);
                                System.out.println("------------------------------------");
                                continue; // Volver al inicio del bucle while (mostrar menú)
                            } else {
                                saldo -= montoRetiro; // Restar el monto del saldo
                                System.out.println("------------------------------------");
                                System.out.println("Retiro exitoso.");
                                System.out.printf(Locale.US, "Su nuevo saldo es: $%.2f%n", saldo);
                                System.out.println("------------------------------------");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Entrada inválida. Por favor, ingrese un número.");
                            scanner.next(); // Limpiar el buffer del scanner
                        }
                        break; // Salir del switch

                    case 4:
                        // Salir
                        System.out.println("------------------------------------");
                        System.out.println("Gracias por usar el Cajero Automático. ¡Hasta pronto!");
                        System.out.println("------------------------------------");
                        break; // Salir del switch (y el bucle do-while terminará)

                    default:
                        // Opción inválida (Desafío adicional)
                        System.out.println("------------------------------------");
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                        System.out.println("------------------------------------");
                        break; // Salir del switch
                }
            } catch (InputMismatchException e) {
                System.out.println("------------------------------------");
                System.out.println("Error: Por favor, ingrese un número válido para la opción.");
                System.out.println("------------------------------------");
                scanner.next(); // Limpiar el buffer del scanner en caso de entrada no numérica para la opción
                opcion = 0; // Asignar un valor que no sea 4 para continuar el bucle
            }

        } while (opcion != 4); // El bucle continúa mientras la opción no sea 4

        scanner.close(); // Cerrar el scanner al finalizar el programa
    }
}
