import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int time = 0;

        for (int i = 0; i < 4; i++) {
            time += Integer.parseInt(in.readLine());
        }

        System.out.print(time / 60 + "\n" + time % 60);
    }
}
