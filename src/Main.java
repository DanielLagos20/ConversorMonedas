import java.io.IOException;
import java.util.Scanner;
import api.ProcesarConversion;
import menuOpiones.Menu;
import static api.ProcesarConversion.procesarConversion;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        Menu mostrarMenu = new Menu();
        ProcesarConversion procesarConversion;
        Boolean salir = true;

        while (salir) {
            mostrarMenu.mostrarMenuOpciones();
            int opcionUsuario = teclado.nextInt();
                if (opcionUsuario >= 8){
                        System.out.println("Opción no valida, porfavor intente nuevamente !!");
                }else {
                    switch (opcionUsuario) {
                            case 1:
                                procesarConversion("USD","EUR");
                                break;
                            case 2:
                                procesarConversion("EUR","USD");
                                break;
                            case 3:
                                procesarConversion("CLP","USD");
                                break;
                            case 4:
                                procesarConversion("USD","CLP");
                                break;
                            case 5:
                                procesarConversion("BRL","USD");
                                break;
                            case 6:
                                procesarConversion("USD","BRL");
                                break;
                            case 7:
                                salir = false;
                        }
                    }
        }
        System.out.println("Hasta pronto, gracias por utilizar el sistema de conversion");
    }
}