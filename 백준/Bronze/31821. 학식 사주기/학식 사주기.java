import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }

        int m = Integer.parseInt(in.readLine());

        int sum = 0;
        while (m-- > 0) {
            sum += arr[Integer.parseInt(in.readLine())];
        }

        System.out.print(sum);

    }
}