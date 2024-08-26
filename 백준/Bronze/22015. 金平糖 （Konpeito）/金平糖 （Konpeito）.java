import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int[] arr = new int[3];
        int max = 0;
        
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += (max - arr[i]);
        }

        System.out.print(sum);
    }
}
