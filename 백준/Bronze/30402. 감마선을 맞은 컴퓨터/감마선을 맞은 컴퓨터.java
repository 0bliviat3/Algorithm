import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 15; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < 15; j++) {
                String val = st.nextToken();
                if (val.equals("w")) {
                    System.out.print("chunbae");
                    return;
                } else if (val.equals("b")) {
                    System.out.print("nabi");
                    return;
                } else if (val.equals("g")) {
                    System.out.print("yeongcheol");
                    return;
                }
            }
        }
    }
}
