import java.io.*;
import java.nio.file.*;
import java.text.DecimalFormat;

public class AnalizadorDeLogs {

    public static void main(String[] args) {
        Path rutaLog = Paths.get("errores.log");
        int totalLineas = 0;
        int totalErrores = 0;
        int totalWarnings = 0;

        // Try-with-resources para leer el archivo de forma segura
        try (BufferedReader lector = Files.newBufferedReader(rutaLog)) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                totalLineas++;
                if (linea.contains("ERROR")) {
                    totalErrores++;
                }
                if (linea.contains("WARNING")) {
                    totalWarnings++;
                }
            }

            // Mostrar resumen
            System.out.println("📊 Resumen del análisis de logs:");
            System.out.println("Total de líneas leídas: " + totalLineas);
            System.out.println("Cantidad de errores: " + totalErrores);
            System.out.println("Cantidad de advertencias: " + totalWarnings);

            double porcentaje = totalLineas > 0
                ? ((double)(totalErrores + totalWarnings) / totalLineas) * 100
                : 0;

            DecimalFormat df = new DecimalFormat("#.##");
            System.out.println("Porcentaje de líneas con errores o advertencias: " + df.format(porcentaje) + "%");

        } catch (IOException e) {
            // Si hay error, guardar mensaje en archivo
            guardarError("❌ Error al leer el archivo de logs: " + e.getMessage());
        }
    }

    // Método auxiliar para guardar mensaje de error
    private static void guardarError(String mensaje) {
        Path rutaError = Paths.get("registro_fallos.txt");
        try {
            Files.writeString(rutaError, mensaje + System.lineSeparator(),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("⚠️ Se registró un error en registro_fallos.txt");
        } catch (IOException ex) {
            System.out.println("❌ No se pudo escribir en registro_fallos.txt: " + ex.getMessage());
        }
    }
}
