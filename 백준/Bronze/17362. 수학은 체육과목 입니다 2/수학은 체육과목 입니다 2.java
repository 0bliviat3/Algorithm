import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        int[] arr = {2, 1, 2, 3, 4, 5, 4, 3};

        System.out.print(arr[n % 8]);
    }
}