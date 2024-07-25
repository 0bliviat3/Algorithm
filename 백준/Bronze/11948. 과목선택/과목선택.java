import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int min = Integer.MAX_VALUE;
        int max = 0;
        int sum = 0;

        for (int i = 0; i < 6; i++) {
            int val = Integer.parseInt(in.readLine());
            if (i < 4) {
                min = Math.min(min, val);
                sum += val;
                continue;
            }
            max = Math.max(max, val);
        }

        System.out.print(sum + max - min);
    }
}