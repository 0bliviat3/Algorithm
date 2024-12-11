import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        StringBuilder ans = new StringBuilder();

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            Double a = Double.parseDouble(st.nextToken()) / Double.parseDouble(st.nextToken());
            st = new StringTokenizer(in.readLine());
            Double r = Double.parseDouble(st.nextToken());
            Double b = r * r * Math.PI / Double.parseDouble(st.nextToken());

            if (a < b) {
                ans.append("Whole pizza\n");
                continue;
            }
            ans.append("Slice of pizza\n");
        }

        System.out.print(ans);
    }
}