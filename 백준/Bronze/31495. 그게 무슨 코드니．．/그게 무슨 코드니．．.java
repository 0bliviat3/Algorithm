import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final String CE = "CE";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();

        int len = input.length();

        if (len < 3) {
            System.out.print(CE);
        } else if (input.charAt(0) != '"') {
            System.out.print(CE);
        } else if (input.charAt(0) != input.charAt(len - 1)) {
            System.out.print(CE);
        } else {
            System.out.print(input.replaceAll("\"", ""));
        }
    }
}