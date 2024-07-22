import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = {'N', 'E', 'S', 'W'};

        int cnt = 10;
        int sum = 0;
        while(cnt-- > 0) {
            sum += Integer.parseInt(in.readLine());
        }

        System.out.print(arr[sum % 4]);
    }
}
