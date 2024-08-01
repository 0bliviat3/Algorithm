import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        char[][] arr = new char[row][col];

        for (int i = 0; i < row; i++) {
            arr[i] = in.readLine().toCharArray();
        }

        for (int i = 0; i < row; i++) {
            for (int j = col - 1; j >= 0; j--) {
                ans.append(arr[i][j]);
            }
            ans.append('\n');
        }

        System.out.print(ans);
    }
}
