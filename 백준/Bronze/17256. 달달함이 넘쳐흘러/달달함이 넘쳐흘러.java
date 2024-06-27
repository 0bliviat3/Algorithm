import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[3];
        int[] b = new int[3];
        int[] c = new int[3];

        init(a, in.readLine());
        init(c, in.readLine());

        calculateCake(a, b, c);

        System.out.printf("%d %d %d", b[0], b[1], b[2]);
    }

    static void init(int[] arr, String input) {
        StringTokenizer st = new StringTokenizer(input);
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void calculateCake(int[] a, int[] b, int[] c) {
        b[0] = c[0] - a[2];
        b[1] = c[1] / a[1];
        b[2] = c[2] - a[0];
    }
}
