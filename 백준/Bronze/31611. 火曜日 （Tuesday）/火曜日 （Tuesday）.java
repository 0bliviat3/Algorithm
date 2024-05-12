import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        if (Integer.parseInt(in.readLine()) % 7 == 2) {
            System.out.print(1);
            return;
        }
        System.out.print(0);
    }
}