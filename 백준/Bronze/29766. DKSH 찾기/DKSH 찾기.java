import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();
        
        int cnt = 0;
        while (input.contains("DKSH")) {
            cnt++;
            input = input.replaceFirst("DKSH", "!");
        }

        System.out.print(cnt);
    }
}