import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar datos al usuario
        System.out.print("Ingrese el nombre del paciente: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la edad del paciente: ");
        int edad = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        System.out.print("Ingrese el número de expediente: ");
        String numeroExpediente = scanner.nextLine();

        // Crear objeto y asignar datos
        Paciente paciente = new Paciente();
        paciente.setDatos(nombre, edad, numeroExpediente);

        // Mostrar información
        System.out.println("\n📋 Información del Paciente:");
        paciente.mostrarInformacion();

        scanner.close();
    }
}