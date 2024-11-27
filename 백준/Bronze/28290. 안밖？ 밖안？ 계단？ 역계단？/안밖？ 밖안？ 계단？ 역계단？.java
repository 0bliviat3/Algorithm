import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> map = new HashMap<>();

        map.put("fdsajkl;", "in-out");
        map.put("jkl;fdsa", "in-out");
        map.put("asdf;lkj", "out-in");
        map.put(";lkjasdf", "out-in");
        map.put("asdfjkl;", "stairs");
        map.put(";lkjfdsa", "reverse");

        String input = in.readLine();

        if (map.containsKey(input)) {
            System.out.print(map.get(input));
            return;
        }
        System.out.print("molu");
    }
}