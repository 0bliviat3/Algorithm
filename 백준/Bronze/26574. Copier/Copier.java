import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int n = Integer.parseInt(in.readLine());
        while (n-- > 0) {
            String val = in.readLine();
            ans.append(val).append(' ').append(val).append('\n');
        }
        System.out.print(ans);
    }
}