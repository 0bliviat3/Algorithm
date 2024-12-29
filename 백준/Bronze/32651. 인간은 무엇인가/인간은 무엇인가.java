import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String flag = (n % 2024 == 0 && n < 100_000) ? "Yes" : "No";
        System.out.print(flag);
    }
}
