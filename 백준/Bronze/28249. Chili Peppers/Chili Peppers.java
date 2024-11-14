import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = Map.of(
            "Poblano", 1500,
            "Mirasol", 6000,
            "Serrano", 15500,
            "Cayenne", 40000,
            "Thai", 75000,
            "Habanero", 125000
        );

        int n = Integer.parseInt(in.readLine());
        int sum = 0;
        while (n-- > 0) {
            sum += map.get(in.readLine());
        }

        System.out.print(sum);
    }
}