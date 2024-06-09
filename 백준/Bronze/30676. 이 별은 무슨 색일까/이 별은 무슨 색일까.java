import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int val = Integer.parseInt(in.readLine());

        System.out.print(getColor(val));
    }

    static String getColor(int val) {
        if (val >= 620) {
            return "Red";
        } else if (val >= 590) {
            return "Orange";
        } else if (val >= 570) {
            return "Yellow";
        } else if (val >= 495) {
            return "Green";
        } else if (val >= 450) {
            return "Blue";
        } else if (val >= 425) {
            return "Indigo";
        }
        return "Violet";
    }
}
