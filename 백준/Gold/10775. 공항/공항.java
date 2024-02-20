import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        new BOJ10775Sol().run();
    }
}

class BOJ10775Sol {

    private int[] parent;

    private void clear(int n) {
        parent = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    private int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private boolean isParking(int a) {
        a = find(a);
        if(a == 0) {
            return false;
        }
        parent[a] = a - 1;
        return true;
    }

    private void solve() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        clear(Integer.parseInt(in.readLine()));
        int g = Integer.parseInt(in.readLine());
        int cnt = 0;

        while(g-- > 0) {
            if(isParking(Integer.parseInt(in.readLine()))) {
                cnt++;
            } else {
                while(g-- > 0) {
                    in.readLine();
                }
            }
        }
        System.out.print(cnt);
    }

    void run() {
        try {
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
