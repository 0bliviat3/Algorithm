import java.io.*;

public class Main {
    /*
     A < B 이면 -1 을, A = B 이면 0 을, A > B 이면 1
    */
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(in.readLine());
        int b = Integer.parseInt(in.readLine());
        
        System.out.print(compare(a, b));
    }
    
    static int compare(int a, int b) {
        if (a < b) {
            return -1;
        } else if (a > b) {
            return 1;
        }
        return 0;
    }
}