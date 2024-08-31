import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BigInteger sum = new BigInteger(in.readLine());
        BigInteger gap = new BigInteger(in.readLine());

        sum = sum.subtract(gap);
        sum = sum.divide(new BigInteger("2"));

        System.out.printf("%s\n%s", sum.add(gap).toString(), sum.toString());
    }
}
