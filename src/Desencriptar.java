import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;
/*En esta clase se llevará a cabo el proceso de desencriptado de un texto recibido de un
 archivo de texto, tiene un metodo en el se recibe el nombre del archivo encriptado por
 parte del usuario, un metodo que va a capturar el texto contenido en el archivo,
 otro metodo que se encargará de desencriptar el texto por medio de fuerza bruta y
 otro metodo que detectará si el desencriptado dio información legible para ver el mensaje
 oculto.*/

public class Desencriptar {
    private static boolean desencriptadoLogrado = false;
    private static int claveUsada = 0;

    public static void menuInicioDesencriptado() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite el nombre del archivo encriptado: ");
        String archivoEncriptado = sc.next();
        capturarDatosEncriptadosDesdeArchivo(archivoEncriptado);
    }

    private static void capturarDatosEncriptadosDesdeArchivo(String nombreArchivo) {
        try {
            Reader flujoEntrada = new FileReader(nombreArchivo);
            char[] buffer = new char[10];
            String textoEncriptado = "";
            while (flujoEntrada.read(buffer) != -1) {
                for (char iterador : buffer) {
                    textoEncriptado = textoEncriptado + (char) (iterador);
                }
            }
            forzarDesencriptado(textoEncriptado);
            flujoEntrada.close();
        } catch (IOException e) {
            System.out.println("Archivo inválido");
        }
    }

    private static void forzarDesencriptado(String textoEncriptado) {
        char[] caracteresEncriptados = textoEncriptado.toCharArray();

        while ((desencriptadoLogrado != true) && (claveUsada <= 128)) {
            claveUsada++;
            String cadenasTextoDesifrado = "";
            for (char iterador : caracteresEncriptados) {
                iterador = (char) (iterador - claveUsada);
                cadenasTextoDesifrado = cadenasTextoDesifrado + (char) (iterador);
            }
            detectarIdiomaEspaniol(cadenasTextoDesifrado);
        }
        if (desencriptadoLogrado = !true) {
            System.out.println("no se logro desencriptar");
        }
    }

    private static void detectarIdiomaEspaniol(String cadenasTextoDesifrado) {

        int aciertos = 0;

        if (cadenasTextoDesifrado.contains("de")) {
            aciertos++;
        }
        if (cadenasTextoDesifrado.contains("la")) {
            aciertos++;
        }
        if (cadenasTextoDesifrado.contains("que")) {
            aciertos++;
        }
        if (cadenasTextoDesifrado.contains("el")) {
            aciertos++;
        }
        if (cadenasTextoDesifrado.contains("en")) {
            aciertos++;
        }
        if (cadenasTextoDesifrado.contains("y")) {
            aciertos++;
        }
        if (cadenasTextoDesifrado.contains("a")) {
            aciertos++;
        }
        if (cadenasTextoDesifrado.contains("los")) {
            aciertos++;
        }
        if (cadenasTextoDesifrado.contains("se")) {
            aciertos++;
        }
        if (cadenasTextoDesifrado.contains("del")) {
            aciertos++;
        }
        if (cadenasTextoDesifrado.contains("las")) {
            aciertos++;
        }
        if (cadenasTextoDesifrado.contains("un")) {
            aciertos++;
        }
        if (cadenasTextoDesifrado.contains("por")) {
            aciertos++;
        }
        if (cadenasTextoDesifrado.contains("con")) {
            aciertos++;
        }
        if (cadenasTextoDesifrado.contains("no")) {
            aciertos++;
        }

        if (aciertos > 5) {
            System.out.println("\n" + cadenasTextoDesifrado
                    + "\nClave:  " + claveUsada);
            desencriptadoLogrado = true;
        }
    }
}
