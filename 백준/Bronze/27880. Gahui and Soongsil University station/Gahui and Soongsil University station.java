import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        int sum = 0;

        while ((input = in.readLine()) != null && !input.isEmpty()) {
            StringTokenizer st = new StringTokenizer(input);
            if (st.nextToken().equals("Es")) {
                sum += Integer.parseInt(st.nextToken()) * 21;
            } else {
                sum += Integer.parseInt(st.nextToken()) * 17;
            }
            input = null;
        }

        System.out.print(sum);
    }
}