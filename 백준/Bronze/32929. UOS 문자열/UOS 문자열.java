import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = {'U', 'O', 'S'};

        int n = (Integer.parseInt(in.readLine()) - 1) % 3;

        System.out.print(arr[n]);
    }
}