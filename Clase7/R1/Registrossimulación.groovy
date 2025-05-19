import java.io.IOException;
import java.nio.file.*;

public class RegistroSimulacion {

    public static void main(String[] args) {
        try {
            guardarParametros();
            leerParametros();
        } catch (IOException e) {
            System.out.println("❌ Error en la operación de archivos: " + e.getMessage());
        }
    }

    // Método para guardar los parámetros en un archivo dentro de /config
    public static void guardarParametros() throws IOException {
        // Definimos la carpeta y archivo
        Path carpetaConfig = Paths.get("config");
        Path archivoParametros = carpetaConfig.resolve("parametros.txt");

        // Si la carpeta no existe, la creamos
        if (Files.notExists(carpetaConfig)) {
            Files.createDirectories(carpetaConfig);
            System.out.println("📁 Carpeta 'config' creada.");
        }

        // Contenido del archivo
        String parametros = """
                Tiempo de ciclo: 55.8 segundos
                Velocidad de línea: 1.2 m/s
                Número de estaciones: 8
                """;

        // Escribimos el contenido en el archivo
        Files.writeString(archivoParametros, parametros, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        System.out.println("✅ Archivo de parámetros guardado en: " + archivoParametros.toAbsolutePath());
    }

    // Método para leer y mostrar el contenido del archivo
    public static void leerParametros() throws IOException {
        Path archivo = Paths.get("config/parametros.txt");

        if (Files.exists(archivo)) {
            String contenido = Files.readString(archivo);
            System.out.println("\n📄 Contenido del archivo de configuración:");
            System.out.println(contenido);
        } else {
            System.out.println("❌ El archivo de configuración no existe.");
        }
    }
}
