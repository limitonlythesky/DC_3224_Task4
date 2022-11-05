import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface PrimeCompute extends Remote {
    List<Long> getListOfPrimes(PrimeTask t, Long n) throws RemoteException;
    Boolean isPrime(PrimeTask t, Long n) throws RemoteException;
}