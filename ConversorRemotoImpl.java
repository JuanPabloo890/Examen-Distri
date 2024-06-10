import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ConversorRemotoImpl extends UnicastRemoteObject implements ConversorRemoto {

    public ConversorRemotoImpl() throws RemoteException {
        super();
    }
    //Metodos
    public String mensaje() {
        return "***** Conversion Temperaturas *****";
    }

    public double farenheiC(double farenheit) {
        return (farenheit - 32) * 5 / 9;
    }


    public double celciusF(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
}
