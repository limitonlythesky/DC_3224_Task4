import java.io.BufferedWriter;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrimeComputeEngine implements PrimeCompute{
    public List<Long> getListOfPrimes(PrimeTask t, Long n) throws RemoteException
    {
        return t.getListOfPrimes(n);
    }

    public Boolean isPrime(PrimeTask t, Long n) throws RemoteException
    {
        return t.isPrime(n);
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        try
        {
            String name = "PrimeCompute";
            PrimeCompute engine = new PrimeComputeEngine();
            PrimeCompute stub =
                    (PrimeCompute) UnicastRemoteObject.exportObject(engine, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind(name, stub);
            System.out.println("ComputeEngine bound");
        } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
    }
}