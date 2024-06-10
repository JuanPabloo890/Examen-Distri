import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClienteRMI {
    public static void main(String[] args) {
        try {
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);

            ConversorRemoto objetoRemoto = (ConversorRemoto) registro.lookup("Cliente Remoto");

            String mensaje = objetoRemoto.mensaje();
            System.out.println(mensaje);

            while(true){
                Scanner sc = new Scanner(System.in);
                System.out.println("\n1. Farenheit a Celsius");
                System.out.println("2. Celcius a Farenheit");
                System.out.println("3. Salir");
                System.out.print("Seleccione una de las opciones: ");
                int opcion = sc.nextInt();
                double valor;
                switch(opcion){
                    case 1:
                        System.out.println("FARENHEIT A CELSIUS");
                        System.out.print("Ingrese la temperatura: ");
                        valor = sc.nextDouble();
                        double conversionF = objetoRemoto.farenheiC(valor);
                        System.out.println("\nEl resultado de la conversion es: " + conversionF);
                        break;
                    case 2:
                        System.out.println("CELSIUS a FARENHEIT");
                        System.out.print("Ingrese la temperatura: ");
                        valor = sc.nextDouble();
                        double conversionC = objetoRemoto.celciusF(valor);
                        System.out.println("El resultado de la conversion es: " + conversionC);
                        break;
                    case 3:
                        System.out.println("Saliendo....");
                        return;
                    default:
                        System.out.println("Opcion invalida. Ingrese nuevamente");
                }
            }

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
