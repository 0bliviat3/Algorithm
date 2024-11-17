import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int sum = 0;
        int mul = 1;
        int max = 0;

        while (st.hasMoreTokens()) {
            int val = Integer.parseInt(st.nextToken());
            max = Math.max(max, val);
            sum += val;
            mul *= val;
        }

        sum -= max;
        mul /= max;

        if (sum == max) {
            System.out.print(1);
        } else if (mul == max) {
            System.out.print(2);
        } else {
            System.out.print(3);
        }
    }
}
