import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int row = Integer.parseInt(in.readLine());
        int col = Integer.parseInt(in.readLine());

        StringBuilder ans  = new StringBuilder();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans.append('*');
            }
            ans.append('\n');
        }

        System.out.print(ans);
    }
}
