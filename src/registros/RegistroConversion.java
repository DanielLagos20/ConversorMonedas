package registros;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroConversion {

    public void guardarConversion(double cantidad, double resultado, String monedaOrigen, String monedaDestino) {
        String nombreArchivo = "historial_conversiones_monedas.txt";
        // Obtener fecha y hora actual
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String linea = String.format(
                "📅 Fecha: %s%n" +
                        "💰 Conversión: %.2f %s  →  %.2f %s%n" +
                        "------------------------------------------%n",
                ahora.format(formatoFecha),
                cantidad, monedaOrigen,
                resultado, monedaDestino
        );

        try (FileWriter writer = new FileWriter(nombreArchivo, true)) {
            writer.write(linea);
            System.out.println("✅ Conversión guardada con éxito.");
        } catch (IOException e) {
            System.out.println("❌ Error al guardar conversión: " + e.getMessage());
        }
    }
}

