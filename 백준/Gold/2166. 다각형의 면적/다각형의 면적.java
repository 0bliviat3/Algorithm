import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new Boj2166Sol().run();
    }
}

class Boj2166Sol {

    private static final String DELIM = " ";
    private static final String FORMAT = "%.1f";
    private List<Double> xPoints;
    private List<Double> yPoints;

    private void clear() {
        xPoints = new ArrayList<>();
        yPoints = new ArrayList<>();
    }

    private void init(String input) {
        StringTokenizer st = new StringTokenizer(input, DELIM);
        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());
        xPoints.add(x);
        yPoints.add(y);
    }

    private String calcalate(int n) {
        xPoints.add(xPoints.get(0));
        yPoints.add(yPoints.get(0));
        double sum = 0d;
        for(int i = 0; i < n; i++) {
            sum += (xPoints.get(i) * yPoints.get(i + 1));
            sum -= (yPoints.get(i) * xPoints.get(i + 1));
        }
        sum = Math.abs(sum);
        sum /= 2;
        return String.format(FORMAT, sum);
    }

    private void process() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        clear();
        for(int i = 0; i < n; i++) {
            init(in.readLine());
        }
        System.out.print(calcalate(n));
    }

    void run() {
        try {
            process();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}