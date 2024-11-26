import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int sum = 0;
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = in.readLine().toCharArray();
        }

        in.readLine();

        for (int i = 0; i < n; i++) {
            String input = in.readLine();
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == input.charAt(j)) {
                    sum++;
                }
            }
        }

        System.out.print(sum);


    }
}