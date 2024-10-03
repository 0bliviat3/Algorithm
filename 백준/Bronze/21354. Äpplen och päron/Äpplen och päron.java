import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int a = Integer.parseInt(st.nextToken()) * 7;
        int b = Integer.parseInt(st.nextToken()) * 13;

        if (a > b) {
            System.out.print("Axel");
        } else if (b > a) {
            System.out.print("Petra");
        } else {
            System.out.print("lika");
        }
    }
}
