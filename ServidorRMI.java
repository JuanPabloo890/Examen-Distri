import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorRMI {
    public static void main(String[] args) {
        try {
            //Crear una interfaz de la implemetacion conversorRemoto
            ConversorRemoto objetoRemoto = new ConversorRemotoImpl();

            Registry registro = LocateRegistry.createRegistry(1099);

            registro.rebind("Cliente Remoto", objetoRemoto);

            System.out.println("Servidor iniciando... ");

        }catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
