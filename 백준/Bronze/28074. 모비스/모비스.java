import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] input = in.readLine().toCharArray();
        
        String mobis = new String("MOBIS");
        int size = mobis.length();
        Set<Character> set = mobis.chars()
                                .mapToObj(c -> Character.valueOf((char) c))
                                .collect(Collectors.toSet());
        
        int cnt = 0;
        for (char c : input) {
            if (set.remove(c)) {
                cnt++;
            }
        }

        if (cnt == size) {
            System.out.print("YES");
            return;
        }
        System.out.print("NO");
    }
}
