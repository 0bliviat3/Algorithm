import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {/* run */}

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getPowDist(Point p) {
            return (int) (Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
        }
    }

    static class BOJ1002Sol {

        int compare(int r1, int r2, int d) {
            if (d == 0 && r1 == r2) {
                return -1;
            } else if (Math.pow(Math.abs(r1 - r2), 2) == d || Math.pow(r1 + r2, 2) == d) {
                return 1;
            } else if (Math.pow(Math.abs(r1 - r2), 2) < d && d < Math.pow(r1 + r2, 2)) {
                return 2;
            } 
            return 0;
        }

        int process(String info) {
            StringTokenizer st = new StringTokenizer(info);

            Point jo = new Point(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
            int r1 = Integer.parseInt(st.nextToken());
            Point baek = new Point(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
            int r2 = Integer.parseInt(st.nextToken());


            return compare(r1, r2, jo.getPowDist(baek));
        }

        void solve() throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder ans = new StringBuilder();
            int t = Integer.parseInt(in.readLine());

            while (t-- > 0) {
                ans.append(process(in.readLine())).append('\n');
            }
            System.out.print(ans);
        }
    }

    static {
        try {
            new BOJ1002Sol().solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
