import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ17435Sol().run();
    }
}

class BOJ17435Sol {
    private List<Integer> parents;
    private static final int MAX_N = 500_000;

    private void clear(String input, int m) {
        StringTokenizer st = new StringTokenizer(input);
        parents = new ArrayList<>();
        parents.add(null);
        for(int i = 0; i < m; i++) {
            parents.add(Integer.parseInt(st.nextToken()));
        }
    }

    private void solve() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int m = Integer.parseInt(in.readLine());
        clear(in.readLine(), m);
        SparseTable table = new SparseTable(parents, m, MAX_N);
        table.setTable();
        int q = Integer.parseInt(in.readLine());
        while(q-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            ans.append(table.getVal(k, n)).append('\n');
        }
        System.out.print(ans);
    }

    void run() {
        try {
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}


/**
 * 스파스 테이블 알고리즘 : 최소 공통 조상 선행 알고리즘
 */
class SparseTable {

    private final List<Integer> parents;
    private int[][] table;
    private int n, h;

    public SparseTable(final List<Integer> parents, int n, int h) {
        this.parents = parents;
        this.n = n;
        this.h = getLog(h);
        table = new int[this.h + 1][n + 1];
    }

    private int getLog(int maxHeight) {
        return (int) Math.ceil(Math.log(maxHeight) / Math.log(2)) + 1;
    }

    public void setTable() { // 1부터 시작한다고 가정.
        for(int i = 1; i <= n; i++) {
            table[0][i] = parents.get(i);
        }
        for(int k = 1; k <= h; k++) {
            for(int i = 1; i <= n; i++) {
                int temp = table[k - 1][i];
                table[k][i] = table[k - 1][temp];
            }
        }
    }

    public int getVal(int val, int k) {
        for(int i = h; 0 <= i; i--) {
            if(k >= (1 << i)) {
                val = table[i][val];
                k -= (1 << i);
            }
        }
        return val;
    }



}

