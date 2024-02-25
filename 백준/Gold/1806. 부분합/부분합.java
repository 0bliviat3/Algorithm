import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ1806Sol().run();
    }
}

class SumObj {
    int sum;
    int start;
    int end;

    public void add(int val) {
        sum += val;
        start++;
    }

    public void remove(int val) {
        sum -= val;
        end++;
    }

    public boolean compare(int standard) {
        return sum >= standard;
    }

    public int length() {
        return start - end;
    }
}

class BOJ1806Sol {
    private SumObj sum;
    private int n, s;
    private int[] numbers;

    private void clear(String input) {
        StringTokenizer st = new StringTokenizer(input);
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        numbers = new int[n];
        sum = new SumObj();
    }

    private void init() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        clear(in.readLine());
        System.out.print(solve(in.readLine()));
    }

    private int solve(String arr) {
        StringTokenizer st = new StringTokenizer(arr);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            sum.add(numbers[i]);
            while(sum.compare(s)) {
                min = Math.min(min, sum.length());
                sum.remove(numbers[sum.end]);
            }
        }
        if(min == Integer.MAX_VALUE) {
            return 0;
        }
        return min;
    }

    void run() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}