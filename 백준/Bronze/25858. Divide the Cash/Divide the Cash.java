import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int sum = 0;
        List<Integer> list = new ArrayList<>();

        while (n-- > 0) {
            int val = Integer.parseInt(in.readLine());
            list.add(val);
            sum += val;
        }

        d /= sum;

        for (int i : list) {
            ans.append(i * d).append('\n');
        }
        

        System.out.print(ans);
    }
}