import java.io.*;
import java.util.Scanner;

public class Encriptacion {
    private final static int CODE = 12;
    private final static String newFile = "encriptado.txt";

    public static void menuInicio() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite el nombre del archivo de texto: ");
        String nombre = sc.next();
        encriptarTexto(nombre);

    }

    private static void encriptarTexto(String archivo) {

        try {
            Reader flujoEntrada = new FileReader(archivo);
            char[] buffer = new char[10];
            String texto = "";
            while (flujoEntrada.read(buffer) != -1) {
                for (char a : buffer) {
                    a = (char) (a + CODE);
                    texto = texto + a;
                }
            }
            crearArchivoEncriptado(texto);
            flujoEntrada.close();
        } catch (IOException e) {
            System.out.println("Archivo inválido");
        }
    }

    private static void crearArchivoEncriptado(String texto) {
        try {
            Writer flujoSalida = new FileWriter(newFile);

            flujoSalida.write(texto.toCharArray());

            System.out.println("Se completó el encriptado, archivo creado:\n" + newFile);
            flujoSalida.close();
        } catch (IOException e) {
            System.out.println("No se creo el archivo.");
        }
    }
}
