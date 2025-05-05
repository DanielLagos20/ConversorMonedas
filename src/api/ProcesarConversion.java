package api;
import registros.RegistroConversion;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ProcesarConversion {
    public static void procesarConversion(String monedaBase, String monedaDestino) throws IOException {
        RegistroConversion registro = new RegistroConversion();
        ApiClient consultaApi = new ApiClient();
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese cantidad en " + monedaBase + ": ");
        double cantidadMoneda = teclado.nextDouble();
        double resultadoConversion = consultaApi.obtenerConversion(monedaBase, monedaDestino, cantidadMoneda);
        System.out.println("\uD83E\uDE99 Tasa de cambio actual:");
        DecimalFormat formato = new DecimalFormat("#.00");
        System.out.println(formato.format(cantidadMoneda) + " " + monedaBase + " equivale a " + formato.format(resultadoConversion) + " " + monedaDestino);
        registro.guardarConversion(cantidadMoneda, resultadoConversion, monedaBase, monedaDestino);
    }

}
