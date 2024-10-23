import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ24079
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int sum = Integer.parseInt(in.readLine());
        sum += Integer.parseInt(in.readLine());

        if (Integer.parseInt(in.readLine()) >= sum) {
            System.out.print(1);
            return;
        }
        System.out.print(0);
    }
}