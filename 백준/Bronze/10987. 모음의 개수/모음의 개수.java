import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] word = in.readLine().toCharArray();

        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');


        int cnt = 0;
        for (char val : word) {
            if (set.contains(val)) {
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}
