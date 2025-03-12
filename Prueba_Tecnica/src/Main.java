import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // Mostrar el menú de opciones de manera infinita hasta que se pulse la opción 4 para finalizar el programa
            System.out.println("Seleccione una opción:");
            System.out.println("1. Calculo de IMC");
            System.out.println("2. Suma de dígitos de 1 a N");
            System.out.println("3. Mover ceros al final en un array");
            System.out.println("4. Salir");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Calcular el IMC
                    System.out.println("Nota: Use una coma (,) para los valores decimales.");
                    System.out.print("Introduzca el peso (kg): ");
                    double weight = scanner.nextDouble();
                    System.out.print("Introduzca la altura (m): ");
                    double height = scanner.nextDouble();
                    String result = calculateBMI(weight, height);
                    System.out.println("El resultado del IMC es: " + result);
                    break;
                case 2:
                    // Suma de dígitos de 1 a N
                    System.out.print("Introduzca el valor de N: ");
                    int N = scanner.nextInt();
                    int sumDigit = sumOfDigits(N);
                    System.out.println("La suma de los dígitos de 1 a " + N + " es: " + sumDigit);
                    break;
                case 3:
                    // Mover ceros al final en un array
                    System.out.print("Introduzca la longitud del array: ");
                    int length = scanner.nextInt();
                    Object[] array = new Object[length];
                    for (int i = 0; i < length; i++) {
                        System.out.print("Introduzca el tipo de dato (int, double, boolean, string): ");
                        String type = scanner.next();
                        System.out.print("Introduzca el valor: ");
                        switch (type.toLowerCase()) {
                            case "int":
                                array[i] = scanner.nextInt();
                                break;
                            case "double":
                                array[i] = scanner.nextDouble();
                                break;
                            case "boolean":
                                array[i] = scanner.nextBoolean();
                                break;
                            case "string":
                                array[i] = scanner.next();
                                break;
                            default:
                                System.out.println("Tipo no válido. Intente de nuevo.");
                                i--;
                                break;
                        }
                    }
                    Object[] arrayRes = moveZeros(array);
                    System.out.print("Array resultante (tras mover los ceros al final): ");
                    for (Object obj : arrayRes) {
                        System.out.print(obj + " ");
                    }
                    System.out.println();
                    break;
                case 4:
                    // Salir del programa
                    System.out.println("EXIT");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    /**
     * Calcula el Índice de Masa Corporal (IMC) dado el peso y la altura.
     * @param weight Peso en kilogramos.
     * @param height Altura en metros.
     * @return Una cadena que indica la categoría del IMC.
     */
    public static String calculateBMI(double weight, double height) {
        double IMC = weight / Math.pow(height, 2);

        if (IMC <= 18.5) return "Infrapeso";
        if (IMC <= 25.0) return "Normal";
        if (IMC <= 30.0) return "Sobrepeso";
        return "Obeso";
    }

    /**
     * Calcula la suma de los dígitos de todos los números de 1 a N.
     * @param N El número hasta el cual se suman los dígitos.
     * @return La suma de los dígitos de 1 a N.
     */
    public static int sumOfDigits(int N) {
        if (N == 0) return 0; // Caso base: si N es 0, la suma es 0
        return sumOfDigits(N - 1) + sumEachDigit(N);
    }

    /**
     * Suma los dígitos de un número dado.
     * @param num El número cuyos dígitos se suman.
     * @return La suma de los dígitos del número.
     */
    private static int sumEachDigit(int num) {
        if (num == 0) return 0;
        return (num % 10) + sumEachDigit(num / 10); // Extraer y sumar los dígitos recursivamente
    }

    /**
     * Mueve todos los ceros en un array al final, manteniendo el orden de los demás elementos.
     * @param array El array de entrada.
     * @return Un nuevo array con los ceros movidos al final.
     */
    public static Object[] moveZeros(Object[] array) {
        // Crear una lista para almacenar los elementos no cero
        List<Object> resultList = new ArrayList<>();
        // Contador para llevar la cuenta de los ceros
        int counter = 0;

        // Recorrer el array de entrada
        for (Object obj : array) {
            // Si el elemento es un entero y es igual a 0, incrementar el contador
            if (obj instanceof Integer && (Integer) obj == 0) {
                counter++;
            } else {
                // Si el elemento no es un cero, añadirlo a la lista de resultados
                resultList.add(obj);
            }
        }

        // Añadir los ceros al final de la lista de resultados
        for (int i = 0; i < counter; i++) {
            resultList.add(0);
        }

        // Convertir la lista de resultados de nuevo a un array y devolverlo
        return resultList.toArray();
    }
}