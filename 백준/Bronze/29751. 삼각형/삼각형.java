import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        double w = Double.parseDouble(st.nextToken());
        double h = Double.parseDouble(st.nextToken());

        System.out.printf("%.1f", w * h / 2);
    }
}
