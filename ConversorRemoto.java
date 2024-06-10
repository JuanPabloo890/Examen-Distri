import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ConversorRemoto extends Remote {
    String mensaje() throws RemoteException;
    double farenheiC (double farenheit) throws RemoteException;
    double celciusF (double celcius) throws RemoteException;
}
