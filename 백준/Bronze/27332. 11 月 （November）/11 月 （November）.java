import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(in.readLine());
        
        a += Integer.parseInt(in.readLine()) * 7;

        if (a > 30) {
            System.out.print(0);
            return;
        }
        System.out.print(1);

        
    }
}