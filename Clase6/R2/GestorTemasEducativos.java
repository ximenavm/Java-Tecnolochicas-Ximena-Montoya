import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Collections;
import java.util.Comparator;

public class GestorTemasEducativos {

    public static void main(String[] args) {
        // Lista concurrente para temas activos
        CopyOnWriteArrayList<Tema> temasActivos = new CopyOnWriteArrayList<>();

        // Agregamos algunos temas de ejemplo
        temasActivos.add(new Tema("Biología Celular", 2));
        temasActivos.add(new Tema("Genética Molecular", 1));
        temasActivos.add(new Tema("Bioética", 3));
        temasActivos.add(new Tema("Microbiología", 1));

        // Muestra original
        System.out.println("📋 Temas registrados:");
        for (Tema t : temasActivos) {
            System.out.println(t);
        }

        // Orden natural (por título)
        Collections.sort(temasActivos);
        System.out.println("\n🔤 Temas ordenados alfabéticamente:");
        for (Tema t : temasActivos) {
            System.out.println(t);
        }

        // Orden por prioridad usando Comparator
        temasActivos.sort(Comparator.comparingInt(Tema::getPrioridad));
        System.out.println("\n📊 Temas ordenados por prioridad (1=Urgente → 3=Opcional):");
        for (Tema t : temasActivos) {
            System.out.println(t);
        }

        // Repositorio concurrente de recursos (título → recurso)
        ConcurrentHashMap<String, String> repositorio = new ConcurrentHashMap<>();
        repositorio.put("Biología Celular", "https://recursos.edu/bio-celular");
        repositorio.put("Genética Molecular", "https://recursos.edu/genetica");
        repositorio.put("Bioética", "https://recursos.edu/bioetica");
        repositorio.put("Microbiología", "https://recursos.edu/microbiologia");

        // Mostrar recursos
        System.out.println("\n📚 Repositorio compartido de recursos:");
        for (String titulo : repositorio.keySet()) {
            System.out.println("- " + titulo + " → " + repositorio.get(titulo));
        }
    }
}
