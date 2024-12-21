import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int lv = Integer.parseInt(st.nextToken());
        switch (st.nextToken()) {
            case "miss":
                lv *= 0;
                break;
            case "bad":
                lv *= 200;
                break;
            case "cool":
                lv *= 400;
                break;
            case "great":
                lv *= 600;
                break;
            case "perfect":
                lv *= 1000;
                break;       
            default:
                break;
        }

        System.out.print(lv);
    }
}