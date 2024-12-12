import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int A = 1;
        int B = 1;

        while (n-- > 0) {
            A += a;
            B += b;
            if (B > A) {
                int c = B;
                B = A;
                A = c;
            } else if (A == B) {
                B--;
            }
        }

        System.out.println(A + " " + B);
    }
}