import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(in.readLine());
        int b = Integer.parseInt(in.readLine());

        
        if (a - b <= 60) {
            System.out.print(a * 1500);
            return;
        }

        System.out.print((a - b - 60) * 3000 + (60 + b) * 1500);

    }
}
