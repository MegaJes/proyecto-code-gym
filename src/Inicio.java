import java.util.Scanner;

public class Inicio {

    private static int cierre = 0;
    private static String opc = "";

    public static void opciones() {
        Scanner sc = new Scanner(System.in);
        for (; cierre != 1;) {
            System.out.println("Elija una opción\n"
                    + "1.Encriptar un archivo\n"
                    + "2.Desencriptar nuevo archivo encriptado\n"
                    + "3.Salir");
            opc = sc.next();
            switch (opc) {
                case "1":
                    Encriptacion.menuInicio();
                    break;
                case "2":
                    Desencriptar.menuInicio();
                    break;
                case "3":
                    cierre = 1;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }
}
