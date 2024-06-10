import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClienteRMI {
    public static void main(String[] args) {
        boolean bucle = true;
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            ConversorRemoto stub = (ConversorRemoto) registry.lookup("Conversor");

            Scanner scanner = new Scanner(System.in);
            while(bucle){
                System.out.println("Seleccione la conversión:");
                System.out.println("1. Celsius a Fahrenheit");
                System.out.println("2. Fahrenheit a Celsius");
                System.out.println("3. Salir");
                System.out.print("Ingrese su respuesta: ");

                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese la temperatura: ");
                        double temperatura1 = scanner.nextDouble();
                        double resultado1 = stub.celsiusToFahrenheit(temperatura1);
                        System.out.println("Conversión: ");
                        System.out.println(temperatura1 + " Celsius = " + resultado1 + " Fahrenheit");
                        break;
                    case 2:
                        System.out.println("Ingrese la temperatura:");
                        double temperatura2 = scanner.nextDouble();
                        double resultado2 = stub.fahrenheitToCelsius(temperatura2);
                        System.out.println("Conversión: ");
                        System.out.println(temperatura2 + " Fahrenheit = " + resultado2 + " Celsius");
                        break;
                    case 3:
                        bucle = false;
                        System.out.println("Salir");
                        break;
                    default:
                        System.out.println("Opción inválida");
                        break;
                }
            }
        } catch (Exception e) {
            System.err.println("Error en el cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}