import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> map = new HashMap<>();
        map.put("M", "MatKor");
        map.put("W", "WiCys");
        map.put("C", "CyKor");
        map.put("A", "AlKor");
        map.put("$", "$clear");

        System.out.print(map.get(in.readLine()));
    }
}
