import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        BigInteger a = new BigInteger(in.readLine());
        BigInteger b = new BigInteger(in.readLine());
        BigInteger c = new BigInteger(in.readLine());

        System.out.println(b.subtract(c).divide(a));
    }
}
