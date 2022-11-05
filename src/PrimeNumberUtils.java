import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrimeNumberUtils {
    public static void main(String[] args) {
        try {
            String name = "PrimeCompute";
            Registry registry = LocateRegistry.getRegistry(null);
            PrimeCompute prime = (PrimeCompute) registry.lookup(name);

            PrimeTask o = new PrimeObject();
            Long l = 100000L, sum = 0L;
            List<Long> p = prime.getListOfPrimes(o, l);
            for (Long n : p) {
                sum += n;
                //System.out.println(sum);
            }
            System.out.println(sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}