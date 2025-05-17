// Entrada.java
public class Entrada {
    // Atributos
    private String nombreEvento;
    private double precioEntrada;

    // Constructor
    public Entrada(String nombreEvento, double precioEntrada) {
        this.nombreEvento = nombreEvento;
        this.precioEntrada = precioEntrada;
    }

    // Método público para mostrar la información
    public void mostrarInformacion() {
        System.out.println("Evento: " + this.nombreEvento + " | Precio: $" + String.format("%.1f", this.precioEntrada));
    }

    // Getters (opcional, pero buena práctica si necesitas acceder a los atributos desde fuera)
    public String getNombreEvento() {
        return nombreEvento;
    }

    public double getPrecioEntrada() {
        return precioEntrada;
    }
}