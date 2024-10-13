import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int cnt = 0;
        boolean flag = false;
        int[] arr = {999, 7999, 259};

        for (int i = 0; i < 3; i++) {
            if (Integer.parseInt(st.nextToken()) > arr[i]) {
                cnt++;
                if (i == 0) {
                    flag = true;
                }
            }
        }

        if (cnt > 1 && flag) {
            System.out.print("Very Good");
        } else if (flag) {
            System.out.print("Good");
        } else {
            System.out.print("Bad");
        }
    }
}
