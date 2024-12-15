import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int m = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());

        if (m < p) {
            System.out.print('P');
        } else if (m > p) {
            System.out.print('M');
        } else {
            System.out.print('E');
        }
    }
}