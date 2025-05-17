public class Paciente {
    // Atributos
    private String nombre;
    private int edad;
    private String numeroExpediente;

    // Método para asignar datos
    public void setDatos(String nombre, int edad, String numeroExpediente) {
        this.nombre = nombre;
        this.edad = edad;
        this.numeroExpediente = numeroExpediente;
    }

    // Método para mostrar la información
    public void mostrarInformacion() {
        System.out.println("Paciente: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Expediente: " + numeroExpediente);
    }
}