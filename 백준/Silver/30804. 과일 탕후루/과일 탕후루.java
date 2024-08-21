import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
    }

    static class BOJ30804Sol {

        int n;
        int[] kinds;
        int[] stick;

        void clear(int n) {
            this.n = n;
            this.stick = new int[n];
            this.kinds = new int[10];
        }

        void makeTangHuru(String input) {
            StringTokenizer st = new StringTokenizer(input);
            for (int i = 0; i < n; i++) {
                stick[i] = Integer.parseInt(st.nextToken());
            }
        }

        int length(int point1, int point2, int cnt, int max, int kind) {
            if (point1 >= n) {
                return max;
            }
            if (kinds[stick[point1]]++ == 0) {
                kind++;
            }
            if (kind > 2) {          
                if (--kinds[stick[point2]] == 0) {
                    kind--;
                }
                cnt--;
                point2++;
            }
            cnt++;
            max = Math.max(max, cnt);
            return length(point1 + 1, point2, cnt, max, kind);
        }

        void solve() throws IOException {
            BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in));
            int n = Integer.parseInt(in.readLine());
            clear(n);
            makeTangHuru(in.readLine());
            System.out.print(
                length(0, 0, 0, 0, 0));
        }

    }

    static {
        try {
            new BOJ30804Sol().solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
