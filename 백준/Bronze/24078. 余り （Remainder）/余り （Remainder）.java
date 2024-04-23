import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(in.readLine());
        System.out.print(x % 21);
    }
}