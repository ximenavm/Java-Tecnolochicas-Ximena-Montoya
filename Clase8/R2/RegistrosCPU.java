import java.util.HashSet;
import java.util.Scanner;

// Excepción personalizada
class ConsumoCriticoException extends Exception {
    public ConsumoCriticoException(String mensaje) {
        super(mensaje);
    }
}

public class MonitorCPU {

    public static void main(String[] args) {
        HashSet<Integer> registrosCPU = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("🔍 Ingrese valores de consumo de CPU (%). Escriba 'fin' para terminar.");

        try {
            while (true) {
                System.out.print("Ingrese consumo de CPU: ");
                String entrada = scanner.nextLine();

                if (entrada.equalsIgnoreCase("fin")) {
                    break;
                }

                int valor;

                // Validar que sea numérico
                try {
                    valor = Integer.parseInt(entrada);
                } catch (NumberFormatException e) {
                    System.out.println("Error: Entrada no numérica. Intente de nuevo.");
                    continue;
                }

                // Validar rango permitido
                if (valor < 0 || valor > 100) {
                    System.out.println("Valor fuera de rango (0-100%).");
                    continue;
                }

                // Validar duplicado
                if (registrosCPU.contains(valor)) {
                    System.out.println("Valor duplicado. Ya fue registrado.");
                    continue;
                }

                // Validar consumo crítico
                if (valor > 95) {
                    throw new ConsumoCriticoException("🔥 Consumo crítico detectado: " + valor + "%");
                }

                registrosCPU.add(valor);
                System.out.println("Registro aceptado: " + valor + "%");
            }

            System.out.println("\n Registros finales:");
            for (int registro : registrosCPU) {
                System.out.println("CPU: " + registro + "%");
            }

        } catch (ConsumoCriticoException e) {
            System.out.println("Alerta: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        } finally {
            System.out.println("Finalizando monitoreo de CPU.");
            scanner.close();
        }
    }
}
