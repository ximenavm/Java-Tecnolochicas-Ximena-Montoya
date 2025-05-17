// SimuladorFarmacia.java
import java.util.Scanner;
import java.util.Locale; // Para asegurar que el punto decimal sea '.'

public class SimuladorFarmacia {

    public static void main(String[] args) {
        // Configurar Locale para entrada/salida con punto decimal.
        // Es una buena práctica, especialmente si el sistema podría tener una configuración regional diferente.
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Bienvenido al Simulador de Farmacia");

        // Solicitar datos al usuario
        System.out.print("Ingrese el nombre del medicamento: ");
        String nombreMedicamento = scanner.nextLine();

        System.out.print("Ingrese el precio unitario del medicamento: ");
        double precioUnitario = scanner.nextDouble();

        System.out.print("Ingrese la cantidad de piezas: ");
        int cantidadPiezas = scanner.nextInt();

        // Calcular el total sin descuento
        // Usaremos 'var' aquí para la inferencia de tipo.
        // El compilador inferirá que totalSinDescuento es de tipo double.
        var totalSinDescuento = precioUnitario * cantidadPiezas;

        // Determinar si aplica descuento y calcular el monto del descuento usando operador ternario.
        // El descuento es del 15% si el total supera $500.00.
        boolean aplicaDescuento = totalSinDescuento > 500.00;

        // El valor del descuento solo debe calcularse si el total supera los $500.00.
        // Usamos el operador ternario para esto. Si no aplica, el descuento es 0.0.
        double montoDescuento = aplicaDescuento ? totalSinDescuento * 0.15 : 0.0;

        // Calcular el total a pagar
        double totalAPagar = totalSinDescuento - montoDescuento;

        // Mostrar el resumen en consola
        System.out.println("\n--- Resumen de la Compra ---");
        System.out.println("Medicamento: " + nombreMedicamento);
        System.out.println("Cantidad: " + cantidadPiezas);
        // Usamos String.format con Locale.US para asegurar un decimal y el punto como separador
        System.out.println("Precio unitario: $" + String.format(Locale.US, "%.1f", precioUnitario));
        System.out.println("Total sin descuento: $" + String.format(Locale.US, "%.1f", totalSinDescuento));
        System.out.println("¿Aplica descuento?: " + aplicaDescuento);
        System.out.println("Descuento: $" + String.format(Locale.US, "%.1f", montoDescuento));
        System.out.println("Total a pagar: $" + String.format(Locale.US, "%.1f", totalAPagar));

        scanner.close(); // Es buena práctica cerrar el scanner para liberar recursos.
    }
}
