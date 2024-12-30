import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int[] arr = new int[3];
        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        arr[2] = Integer.parseInt(st.nextToken());

        if (arr[0] == arr[1] && arr[1] == arr[2]) {
            System.out.println(2);
            return;
        }

        for (int i = 0; i < 3; i++) {
            int sum = 0;
            boolean flag = false;
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    continue;
                }
                if (arr[i] < arr[j]) {
                    flag = true;
                    break;
                }
                sum += (arr[j] * arr[j]);
            }
            if (flag) {
                continue;
            }
            if (sum == arr[i] * arr[i]) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }
}