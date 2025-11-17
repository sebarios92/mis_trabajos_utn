import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ManejoExcepciones {

    private static Scanner scanner = new Scanner(System.in);

    // 1) División segura
    public static void divisionSegura() {
        try {
            System.out.print("Ingrese el dividendo: ");
            int a = Integer.parseInt(scanner.nextLine());

            System.out.print("Ingrese el divisor: ");
            int b = Integer.parseInt(scanner.nextLine());

            int resultado = a / b;
            System.out.println("Resultado: " + resultado);

        } catch (ArithmeticException e) {
            System.out.println("Error: No se puede dividir por cero.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Debe ingresar números enteros.");
        }
    }

    // 2) Conversión de cadena a número
    public static void conversionCadenaANumero() {
        try {
            System.out.print("Ingrese un número entero: ");
            String texto = scanner.nextLine();

            int numero = Integer.parseInt(texto);
            System.out.println("Número ingresado: " + numero);

        } catch (NumberFormatException e) {
            System.out.println("Error: El texto ingresado no es un número entero válido.");
        }
    }

    // 3) Lectura de archivo con FileNotFoundException
    public static void lecturaArchivoSimple() {
        System.out.print("Ingrese el nombre del archivo a leer: ");
        String nombreArchivo = scanner.nextLine();

        try {
            FileReader fr = new FileReader(nombreArchivo);
            BufferedReader br = new BufferedReader(fr);

            String linea;
            System.out.println("\nContenido del archivo:");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

            br.close();
            fr.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: El archivo no existe.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // 4) Excepción personalizada EdadInvalidaException
    public static void validarEdad() {
        try {
            System.out.print("Ingrese una edad: ");
            int edad = Integer.parseInt(scanner.nextLine());

            verificarEdad(edad);
            System.out.println("Edad válida: " + edad);

        } catch (EdadInvalidaException e) {
            System.out.println("Error de edad: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Debe ingresar un número entero para la edad.");
        }
    }

    private static void verificarEdad(int edad) throws EdadInvalidaException {
        if (edad < 0 || edad > 120) {
            throw new EdadInvalidaException("La edad debe estar entre 0 y 120 años.");
        }
    }

    // 5) Uso de try-with-resources
    public static void lecturaArchivoTryWithResources() {
        System.out.print("Ingrese el nombre del archivo a leer (try-with-resources): ");
        String nombreArchivo = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {

            String linea;
            System.out.println("\nContenido del archivo:");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: El archivo no fue encontrado.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
