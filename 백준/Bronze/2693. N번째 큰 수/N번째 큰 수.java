import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int n = Integer.parseInt(in.readLine());
        Integer[] arr = new Integer[10];

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 0; st.hasMoreTokens(); i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr, (a, b) -> b - a);
            ans.append(arr[2]).append('\n');
        }

        System.out.print(ans);
    }
}