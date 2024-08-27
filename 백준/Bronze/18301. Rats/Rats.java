import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int[] n = new int[3];

        for (int i = 0; i < 3; i++) {
            n[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print((n[0] + 1) * (n[1] + 1) / (n[2] + 1) - 1);
    }
}
