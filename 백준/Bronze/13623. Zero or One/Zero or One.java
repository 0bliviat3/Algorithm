import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int[] arr = new int[3];
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        if (sum == 0 || sum == 3) {
            System.out.print('*');
            return;
        }

        sum = (sum == 2) ? 0 : sum;

        for (int i = 0; i < 3; i++) {
            if (arr[i] == sum) {
                System.out.print((char) ('A' + i));
            }
        }
    }
}