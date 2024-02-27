import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        new BOJ11812Sol().solve();
    }
}

class BOJ11812Sol {
    private int k;

    void solve() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        StringBuilder ans = new StringBuilder();
        st.nextToken();
        k = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        while (q-- > 0) {
            ans.append(getDist(in.readLine())).append('\n');
        }
        System.out.print(ans);
    }

    private long getDist(String query) {
        StringTokenizer st = new StringTokenizer(query);
        long a = Long.parseLong(st.nextToken()) + k - 2;
        long b = Long.parseLong(st.nextToken()) + k - 2;
        if(k == 1) {
            return Math.abs(a - b);
        }
        long dist = 0L;
        while(a != b) { // 거슬러 올라가 부모가 다른경우 계속 올라감
            while(a > b) {
                a = a / k + (k - 2);
                dist++;
            }
            while(a < b) {
                b = b / k + (k - 2);
                dist++;
            }
        }
        return dist;
    }

}
