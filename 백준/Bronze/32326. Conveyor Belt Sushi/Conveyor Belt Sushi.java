import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int sum = Integer.parseInt(in.readLine()) * 3;
        sum += Integer.parseInt(in.readLine()) * 4;
        sum += Integer.parseInt(in.readLine()) * 5;

        System.out.print(sum);
    }
}
