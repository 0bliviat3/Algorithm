import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        int seq = in.read() - '가' + 1;
        System.out.print(seq);
    }
}