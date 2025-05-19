import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;

public class RegistroMuestrasBiotecnologia {

    public static void main(String[] args) {
        // Paso 1: ArrayList para registrar todas las especies en orden de llegada
        ArrayList<String> listaMuestras = new ArrayList<>();
        listaMuestras.add("Homo sapiens");
        listaMuestras.add("Mus musculus");
        listaMuestras.add("Arabidopsis thaliana");
        listaMuestras.add("Homo sapiens");  // Muestra replicada

        // Paso 2: HashSet para filtrar especies únicas
        HashSet<String> especiesUnicas = new HashSet<>(listaMuestras);

        // Paso 3: HashMap para asociar ID de muestra con el nombre del investigador
        HashMap<String, String> mapaIDInvestigador = new HashMap<>();
        mapaIDInvestigador.put("M-001", "Dra. López");
        mapaIDInvestigador.put("M-002", "Dr. Hernández");
        mapaIDInvestigador.put("M-003", "Dra. Ramírez");
        mapaIDInvestigador.put("M-004", "Dr. Hernández"); // Muestra replicada

        // Paso 4: Mostrar resultados

        System.out.println("📥 Lista completa y ordenada de especies registradas:");
        for (String especie : listaMuestras) {
            System.out.println("- " + especie);
        }

        System.out.println("\n🧬 Especies únicas procesadas:");
        for (String especieUnica : especiesUnicas) {
            System.out.println("- " + especieUnica);
        }

        System.out.println("\n🧑‍🔬 Asociación ID de muestra → Investigador responsable:");
        for (String id : mapaIDInvestigador.keySet()) {
            String investigador = mapaIDInvestigador.get(id);
            System.out.println(id + " → " + investigador);
        }

        // Paso 5: Búsqueda por ID de muestra
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n🔍 Ingresa un ID de muestra para buscar al investigador (ej. M-002): ");
        String idBuscado = scanner.nextLine();

        if (mapaIDInvestigador.containsKey(idBuscado)) {
            System.out.println("✅ Investigador responsable: " + mapaIDInvestigador.get(idBuscado));
        } else {
            System.out.println("❌ ID no encontrado en el registro.");
        }

        scanner.close();
    }
}
