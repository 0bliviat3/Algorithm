import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * BOJ30031
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        Map<String, Integer> map = new HashMap<>();
        
        map.put("136", 1000);
        map.put("142", 5000);
        map.put("148", 10000);
        map.put("154", 50000);

        int sum = 0;

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            sum += map.get(st.nextToken());
        }

        System.out.print(sum);
    }
}