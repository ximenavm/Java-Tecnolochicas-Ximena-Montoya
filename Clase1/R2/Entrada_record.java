// Entrada_Record.java
public record Entrada_Record(String nombreEvento, double precio) {
    
    public void mostrarInformacionFormateada() {
        System.out.println("Evento: " + this.nombreEvento + " | Precio: $" + String.format("%.1f", this.precio));
    }
}