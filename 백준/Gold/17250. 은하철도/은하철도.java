import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ17250Sol().run();
    }
}

class BOJ17250Sol {

    private int[] parent;
    private int[] planet;

    private void clear(int n) {
        parent = new int[n + 1];
        planet = new int[n + 1];
    }

    private void init() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        clear(n);
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
            planet[i] = Integer.parseInt(in.readLine());
        }
        while(m-- > 0) {
            ans.append(union(in.readLine())).append('\n');
        }
        System.out.print(ans);
    }

    private int getParent(int x) {
        if(parent[x] == x) {
            return x;
        }
        return parent[x] = getParent(parent[x]);
    }

    private int union(String input) {
        StringTokenizer st = new StringTokenizer(input, " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        a = getParent(a);
        b = getParent(b);

        if(a == b) {
            return planet[a];
        }
        if(a < b) {
            parent[b] = a;
            return planet[a] += planet[b];
        }
        parent[a] = b;
        return planet[b] += planet[a];
    }

    void run() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}