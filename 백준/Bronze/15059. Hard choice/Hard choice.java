import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[3];
        int cnt = 0;

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < 3; i++) {
            int now = Integer.parseInt(st.nextToken()) - arr[i];
            if (now > 0) {
                cnt+=now;
            }
        }

        System.out.print(cnt);
    }
}
