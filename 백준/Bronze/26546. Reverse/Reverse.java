import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int n = Integer.parseInt(in.readLine());

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            String val = st.nextToken();

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int size = val.length();
            for (int i = 0; i < size; i++) {
                if (i >= start && i < end) {
                    continue;
                }
                ans.append(val.charAt(i));
            }

            ans.append('\n');
        }

        System.out.print(ans);
    }
}