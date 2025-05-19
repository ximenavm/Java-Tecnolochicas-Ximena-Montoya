// Clase que representa un tema de clase y lo hace comparable por título
public class Tema implements Comparable<Tema> {
    private String titulo;
    private int prioridad; // 1 = urgente, 2 = importante, 3 = opcional

    public Tema(String titulo, int prioridad) {
        this.titulo = titulo;
        this.prioridad = prioridad;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPrioridad() {
        return prioridad;
    }

    // Orden natural: alfabéticamente por título
    @Override
    public int compareTo(Tema otro) {
        return this.titulo.compareToIgnoreCase(otro.titulo);
    }

    @Override
    public String toString() {
        return "[Tema: " + titulo + ", Prioridad: " + prioridad + "]";
    }
}
