// Clase Factura
class Factura {
    private String folio;
    private String cliente;
    private double total;

    // Constructor con parámetros para inicializar todos los atributos.
    public Factura(String folio, String cliente, double total) {
        this.folio = folio;
        this.cliente = cliente;
        this.total = total;
    }

    // Método toString() para mostrar la información de la factura.
    @Override
    public String toString() {
        return "🧾 Factura [folio=" + folio + ", cliente=" + cliente + ", total=$" + total + "]";
    }

    // Método equals() para comparar si dos facturas son iguales por el folio.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Factura otraFactura = (Factura) obj;
        return folio.equals(otraFactura.folio);
    }

    // Método hashCode() basado en el atributo folio.
    @Override
    public int hashCode() {
        return folio.hashCode();
    }

    public String getFolio() {
        return folio;
    }

    public String getCliente() {
        return cliente;
    }

    public double getTotal() {
        return total;
    }
}

// Clase Main
public class Main {
    public static void main(String[] args) {
        // Crear dos facturas con el mismo folio pero diferentes clientes y totales.
        Factura factura1 = new Factura("FAC001", "Juan Pérez", 1450.0);
        Factura factura2 = new Factura("FAC001", "Comercial XYZ", 1450.0);

        // Mostrar ambas facturas con toString().
        System.out.println(factura1);
        System.out.println(factura2);

        // Comparar si son iguales con equals().
        System.out.println("¿Las facturas son iguales?: " + factura1.equals(factura2));

        // Crear una tercera factura con diferente folio
        Factura factura3 = new Factura("FAC002", "Juan Pérez", 1450.0);
        System.out.println("¿Factura 1 y Factura 3 son iguales?: " + factura1.equals(factura3));
    }
}

