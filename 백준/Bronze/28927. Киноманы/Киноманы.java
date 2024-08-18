import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] sum = new int[2];

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            sum[i] += Integer.parseInt(st.nextToken()) * 3;
            sum[i] += Integer.parseInt(st.nextToken()) * 20;
            sum[i] += Integer.parseInt(st.nextToken()) * 120;
        }

        if (sum[0] > sum[1]) {
            System.out.print("Max");
            return;
        } else if (sum[0] == sum[1]) {
            System.out.print("Draw");
            return;
        }
        System.out.print("Mel");
    }
}