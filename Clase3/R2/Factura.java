import java.util.Optional;

// Clase Factura
class Factura {
    private double monto;
    private String descripcion;
    private Optional<String> rfc;

    public Factura(double monto, String descripcion, String rfc) {
        this.monto = monto;
        this.descripcion = descripcion;
        this.rfc = Optional.ofNullable(rfc); // Usa ofNullable para manejar null de forma segura
    }

    public String getResumen() {
        String rfcStr = rfc.map(s -> "RFC: " + s) // Si el RFC está presente, lo formatea
                             .orElse("RFC: [No proporcionado]"); // Si no, muestra el mensaje

        return "Descripción: " + descripcion + "\n" +
               "Monto: $" + monto + "\n" +
               rfcStr;
    }
}

// Clase Principal
public class Principal {
    public static void main(String[] args) {
        // Crear dos facturas: una con RFC y otra sin RFC
        Factura factura1 = new Factura(2500.0, "Servicio de consultoría", "ABCC010101XYZ");
        Factura factura2 = new Factura(1800.0, "Reparación de equipo", null);

        // Imprimir el resumen de ambas facturas
        System.out.println("📄 Factura generada:");
        System.out.println(factura1.getResumen());

        System.out.println("\n📄 Factura generada:");
        System.out.println(factura2.getResumen());
    }
}

