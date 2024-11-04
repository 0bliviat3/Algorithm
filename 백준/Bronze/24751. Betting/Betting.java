import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        double a = Double.parseDouble(in.readLine());
        double b = 100D - a;

        StringBuilder ans = new StringBuilder();
        ans.append(100 / a).append('\n').append(100 / b);

        System.out.print(ans);
    }
}