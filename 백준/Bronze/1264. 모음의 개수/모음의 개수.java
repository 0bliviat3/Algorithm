import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Set<Character> set = new HashSet<>();

        set.add('i');
        set.add('e');
        set.add('o');
        set.add('u');
        set.add('a');

        String input = null;
        StringBuilder ans = new StringBuilder();
        while (!(input = in.readLine()).equals("#")) {
            int cnt = 0;
            input = input.toLowerCase();
            char[] arr = input.toCharArray();
            for (Character c : arr) {
                if (set.contains(c)) {
                    cnt++;
                }
            }
            ans.append(cnt).append('\n');
        }

        System.out.print(ans);
        
    }
}