import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class Desencriptar {
    private static boolean logrado = false;
    private static int code = 0;

    public static void menuInicio() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite el nombre del archivo encriptado: ");
        String nombre = sc.next();
        capturarDatos(nombre);
    }

    private static void capturarDatos(String name) {

        try {

            Reader flujoEntrada = new FileReader(name);
            char[] buffer = new char[10];
            String texto = "";
            while (flujoEntrada.read(buffer) != -1) {
                for (char a : buffer) {
                    texto = texto + (char) (a);
                }
            }
            forzarDesencriptado(texto);
            flujoEntrada.close();
        } catch (IOException e) {
            System.out.println("Archivo inválido");
        }
    }

    private static void forzarDesencriptado(String texto) {
        char[] letras = texto.toCharArray();

        while ((logrado != true)&&(code<=128)) {
            code++;
            String cadenas = "";
            for (char a : letras) {
                a = (char) (a - code);
                cadenas = cadenas + (char) (a);
            }
            detectarIdiomaEspaniol(cadenas);
        }
        if(logrado=!true){
            System.out.println("no se logro desencriptar");
        }
    }

    private static void detectarIdiomaEspaniol(String cadenas) {

        int aciertos = 0;

        if (cadenas.contains("de")) {
            aciertos++;
        }
        if (cadenas.contains("la")) {
            aciertos++;
        }
        if (cadenas.contains("que")) {
            aciertos++;
        }
        if (cadenas.contains("el")) {
            aciertos++;
        }
        if (cadenas.contains("en")) {
            aciertos++;
        }
        if (cadenas.contains("y")) {
            aciertos++;
        }
        if (cadenas.contains("a")) {
            aciertos++;
        }
        if (cadenas.contains("los")) {
            aciertos++;
        }
        if (cadenas.contains("se")) {
            aciertos++;
        }
        if (cadenas.contains("del")) {
            aciertos++;
        }
        if (cadenas.contains("las")) {
            aciertos++;
        }
        if (cadenas.contains("un")) {
            aciertos++;
        }
        if (cadenas.contains("por")) {
            aciertos++;
        }
        if (cadenas.contains("con")) {
            aciertos++;
        }
        if (cadenas.contains("no")) {
            aciertos++;
        }

        if (aciertos > 5) {
            System.out.println("\n" + cadenas
                    + "\nClave:  " + code);
            logrado = true;
        }
    }
}
