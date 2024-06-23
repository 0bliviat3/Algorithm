import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int n = Integer.parseInt(in.readLine());
        
        char[][] files = new char[n][50];
        
        for (int i = 0; i < n; i++) {
            files[i] = in.readLine().toCharArray();
        }
        
        for (int i = 0; i < files[0].length; i++) {
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                if (files[0][i] != files[j][i]) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                ans.append('?');
                continue;
            }
            ans.append(files[0][i]);
        }
        
        System.out.print(ans);
    }
}