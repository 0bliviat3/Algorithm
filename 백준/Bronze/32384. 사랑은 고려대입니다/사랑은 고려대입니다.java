import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int n = Integer.parseInt(in.readLine());
        String val = "LoveisKoreaUniversity";
        while (n-- > 0) {
            ans.append(val).append(' ');
        }
        
        System.out.print(ans);
        
    }
}