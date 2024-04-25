import java.io.*;
import java.util.Scanner;
/*En esta clase se realiza la tarea de encriptar el texto proporcionado desde un archivo de
 texto, posee un metodo para leer el nombre del archivo que ingresa el usuario desde la consola
 otro metodo para encriptar los datos que contiene el archivo y
 otro metodo para guardar el texto encriptado en un nuevo archivo*/

public class Encriptacion {
    private final static int CLAVE_DE_CIFRADO = 12;
    private final static String nuevoArchivo = "encriptado.txt";

    public static void menuInicioEncriptacion() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite el nombre del archivo de texto: ");
        String nombreArchivo = sc.next();
        encriptarTexto(nombreArchivo);

    }

    private static void encriptarTexto(String nombreArchivo) {
        try {
            Reader flujoEntrada = new FileReader(nombreArchivo);
            char[] buffer = new char[10];
            String textoEncriptado = "";
            while (flujoEntrada.read(buffer) != -1) {
                for (char iterador : buffer) {
                    iterador = (char) (iterador + CLAVE_DE_CIFRADO);
                    textoEncriptado = textoEncriptado + iterador;
                }
            }
            crearArchivoEncriptado(textoEncriptado);
            flujoEntrada.close();
        } catch (IOException e) {
            System.out.println("Archivo inválido");
        }
    }

    private static void crearArchivoEncriptado(String textoEncriptado) {
        try {
            Writer flujoSalida = new FileWriter(nuevoArchivo);

            flujoSalida.write(textoEncriptado.toCharArray());

            System.out.println("Se completó el encriptado, archivo creado:\n" + nuevoArchivo);
            flujoSalida.close();
        } catch (IOException e) {
            System.out.println("No se creo el archivo.");
        }
    }
}
