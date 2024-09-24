import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = in.readLine().toCharArray();

        for (int i = 0; i < 3; i++) {
            if (arr[i] != '5') {
                System.out.print("NO");
                return;
            }
        }
        System.out.print("YES");
    }
}
