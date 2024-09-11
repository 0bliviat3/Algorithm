import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String label = "WelcomeToSMUPC";
        int mod = (Integer.parseInt(in.readLine()) - 1) % label.length();

        System.out.print(label.charAt(mod));
    }
}
