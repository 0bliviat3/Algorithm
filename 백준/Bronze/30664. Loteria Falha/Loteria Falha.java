import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        BigInteger mod = new BigInteger("42");

        String input = null;

        while (!(input = in.readLine()).equals("0")) {
            if (new BigInteger(input).mod(mod).equals(BigInteger.ZERO)) {
                ans.append("PREMIADO\n");
                continue;
            }
            ans.append("TENTE NOVAMENTE\n");
        }

        System.out.print(ans);
    }
}
