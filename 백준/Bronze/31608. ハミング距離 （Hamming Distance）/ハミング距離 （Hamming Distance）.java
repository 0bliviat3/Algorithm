import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        String a = in.readLine();
        String b = in.readLine();

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}