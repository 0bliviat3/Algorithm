import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();
        if (input.equalsIgnoreCase("n")) {
            System.out.print("Naver D2");
            return;
        }
        System.out.print("Naver Whale");
    }
}