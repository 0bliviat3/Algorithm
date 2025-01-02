import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        double input = 0D;

        while ((input = Double.parseDouble(in.readLine())) >= 0) {
            ans.append(String.format("Objects weighing %.2f on Earth will weigh %.2f on the moon.\n", input, input * 0.167));
        }

        System.out.print(ans);
    }
}