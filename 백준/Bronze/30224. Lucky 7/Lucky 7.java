import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();

        if (input.contains("7")) {
            if (Integer.parseInt(input) % 7 == 0) {
                System.out.print(3);
            } else {
                System.out.print(2);
            }
        } else {
            if (Integer.parseInt(input) % 7 == 0) {
                System.out.print(1);
            } else {
                System.out.print(0);
            }
        }
    }
}
