import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int sum = 120 - 9 - 4 * 3 - 8;
        sum += Integer.parseInt(in.readLine());
        sum += Integer.parseInt(in.readLine()) * 3;
        sum += Integer.parseInt(in.readLine());

        System.out.printf("The 1-3-sum is %d", sum);
    }
}