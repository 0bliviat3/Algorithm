import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] sum = new int[2];

        for (int i = 0; i < 2; i++) {
            sum[i] += Integer.parseInt(in.readLine()) * 3;
            sum[i] += Integer.parseInt(in.readLine()) * 2;
            sum[i] += Integer.parseInt(in.readLine());
        }

        if (sum[0] > sum[1]) {
            System.out.print('A');
        } else if (sum[0] < sum[1]) {
            System.out.print('B');
        } else {
            System.out.print('T');
        }
    }
}
