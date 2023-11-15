import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    private static final String message = "Hello World, Judge %d!\n";
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(in.readLine());
        in.close();
        
        for(int i = 1; i <= n; i++) {
            sb.append(String.format(message, i));
        }
        
        System.out.print(sb);
    }
}