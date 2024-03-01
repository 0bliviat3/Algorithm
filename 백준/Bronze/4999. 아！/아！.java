import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String a = in.readLine();
        String b = in.readLine();
        
        if(a.length() >= b.length()) {
            System.out.print("go");
            return;
        }
        System.out.print("no");
    }
}