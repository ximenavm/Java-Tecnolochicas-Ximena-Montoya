// Principal.java
public class Principal {
    public static void main(String[] args) {
        // Crear el primer objeto de tipo Entrada
        Entrada entrada1 = new Entrada("Concierto de Rock", 750.0);

        // Crear el segundo objeto de tipo Entrada
        Entrada entrada2 = new Entrada("Partido de Fútbol", 320.5);

        // Llamar al método mostrarInformacion() para cada objeto
        System.out.println("Información de las Entradas (usando Clase):");
        entrada1.mostrarInformacion();
        entrada2.mostrarInformacion();

        System.out.println("\n--- Desafío Adicional: Record ---");
        // Crear un objeto de tipo Entrada_Record
        Entrada_Record entradaRecord1 = new Entrada_Record("Festival de Jazz", 600.0);
        Entrada_Record entradaRecord2 = new Entrada_Record("Exposición de Arte", 150.75);
        System.out.println("Información de las Entradas (usando Record):");
        System.out.println("Evento: " + entradaRecord1.nombreEvento() + " | Precio: $" + String.format("%.1f", entradaRecord1.precio()));
        System.out.println("Evento: " + entradaRecord2.nombreEvento() + " | Precio: $" + String.format("%.1f", entradaRecord2.precio()));

    }
}