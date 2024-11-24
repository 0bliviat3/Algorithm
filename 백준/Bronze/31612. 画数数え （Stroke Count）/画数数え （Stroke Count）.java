import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int sum = 0;

        String input = in.readLine();

        for (int i = 0; i < n; i++) {
            sum += JOI.getVal(input.charAt(i));
        }

        System.out.print(sum);
    }
}

enum JOI {

    J('j', 2),
    O('o', 1),
    I('i', 2);

    private int cnt;
    private char joi;

    JOI(char joi, int cnt) {
        this.joi = joi;
        this.cnt = cnt;
    }

    public boolean isVal(char c) {
        return this.joi == c;
    }

    public int getCnt() {
        return this.cnt;
    }

    public static int getVal(char c) {
        for (JOI val : JOI.values()) {
            if (val.isVal(c)) {
                return val.getCnt();
            }
        }
        return 0;
    }
}
