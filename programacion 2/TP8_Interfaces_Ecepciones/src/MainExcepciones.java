import java.util.Scanner;

public class MainExcepciones {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENÚ EXCEPCIONES ===");
            System.out.println("1) División segura");
            System.out.println("2) Conversión cadena a número");
            System.out.println("3) Lectura de archivo simple");
            System.out.println("4) Excepción personalizada EdadInvalidaException");
            System.out.println("5) Lectura de archivo con try-with-resources");
            System.out.println("0) Salir");
            System.out.print("Elija una opción: ");

            String entrada = scanner.nextLine();

            try {
                opcion = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    ManejoExcepciones.divisionSegura();
                    break;
                case 2:
                    ManejoExcepciones.conversionCadenaANumero();
                    break;
                case 3:
                    ManejoExcepciones.lecturaArchivoSimple();
                    break;
                case 4:
                    ManejoExcepciones.validarEdad();
                    break;
                case 5:
                    ManejoExcepciones.lecturaArchivoTryWithResources();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}
