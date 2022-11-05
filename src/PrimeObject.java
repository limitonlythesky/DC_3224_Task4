import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class PrimeObject implements PrimeTask, Serializable {

    public PrimeObject() {}

    @Override
    public List<Long> getListOfPrimes(Long n) {
        List<Long> temp = new ArrayList<Long>();

        for (long i = 1; i <= n; i++) {
            if (isPrime(i))
                temp.add(i);
        }
        return temp;
    }

    @Override
    public Boolean isPrime(Long n) {
        if (n == 1)
            return false;
        else if (n < 4)
            return true;
        else if (n % 2 == 0)
            return false;
        else if (n < 9)
            return true;
        else if (n % 3 == 0)
            return false;
        else
        {
            int r = (int)Math.floor(Math.sqrt(n));
            int f = 5;
            while (f <= r)
            {
                if (n % f == 0)
                    return false;
                if (n % (f + 2) == 0)
                    return false;
                f = f + 6;
            }
        }
        return true;
    }
}
