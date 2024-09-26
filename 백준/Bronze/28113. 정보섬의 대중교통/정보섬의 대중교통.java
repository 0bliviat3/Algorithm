import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        st.nextToken();
        int bus = Integer.parseInt(st.nextToken());
        int sub = Integer.parseInt(st.nextToken());

        if (bus < sub) {
            System.out.print("Bus");
        } else if (bus == sub) {
            System.out.print("Anything");
        } else {
            System.out.print("Subway");
        }
    }
}
