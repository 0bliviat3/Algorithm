import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        int sad = 0;
        int happy = 0;

        while (n-- > 0) {
            if (Integer.parseInt(st.nextToken()) % 2 == 1) {
                sad++;
                continue;
            }
            happy++;
        }

        if (happy > sad) {
            System.out.print("Happy");
            return;
        }
        System.out.print("Sad");
    }
}
