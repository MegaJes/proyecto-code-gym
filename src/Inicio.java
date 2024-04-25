import java.util.Scanner;
/*En esta clase presentamos un menú sencillo con el cuál el usuario podrá tomar sus decisiones
 de lo que desea hacer según las opciones presentadas*/
public class Inicio {

    private static boolean cierre = false;
    private static String opciones = "";

    public static void opcionesElegibles() {
        Scanner sc = new Scanner(System.in);
        while(cierre != true) {
            System.out.println("Elija una opción\n"
                    + "1.Encriptar un archivo\n"
                    + "2.Desencriptar nuevo archivo encriptado\n"
                    + "3.Salir");
            opciones = sc.next();
            switch (opciones) {
                case "1":
                    Encriptacion.menuInicioEncriptacion();
                    break;
                case "2":
                    Desencriptar.menuInicioDesencriptado();
                    break;
                case "3":
                    cierre = true;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }
}
