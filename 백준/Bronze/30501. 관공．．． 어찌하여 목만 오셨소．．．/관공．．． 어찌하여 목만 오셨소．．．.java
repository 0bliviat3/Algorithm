import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        String input = null;
        while ((input = in.readLine()).indexOf("S") == -1) {/* run */}

        System.out.print(input);
    }
}
