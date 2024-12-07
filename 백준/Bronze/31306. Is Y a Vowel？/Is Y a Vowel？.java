import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int cnt = 0;
        int cnt1 = 0;
        char[] arr = in.readLine().toCharArray();
        for (char c : arr) {
            if (set.contains(c) || c == 'y') {
                cnt++;
            }
            if (set.contains(c)) {
                cnt1++;
            }
        }

        System.out.print(cnt1 + " " + cnt);

    }
}