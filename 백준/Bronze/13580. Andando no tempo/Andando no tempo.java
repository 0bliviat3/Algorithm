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
        int sum = 0;

        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == 0) {
                System.out.print('S');
                return;
            }
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }

        if (arr[0] == arr[1] || arr[0] == arr[2] || arr[1] == arr[2]) {
            System.out.print('S');
            return;
        }

        if ((sum -= max * 2) == 0) {
            System.out.print('S');
            return;
        }

        System.out.print('N');
    }
}