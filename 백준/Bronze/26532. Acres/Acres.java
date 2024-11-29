import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int ok = 4840 * 5;

        StringTokenizer st = new StringTokenizer(in.readLine());
        int zic = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        System.out.println(zic / ok + ((zic % ok == 0) ? 0 : 1));
    }
}