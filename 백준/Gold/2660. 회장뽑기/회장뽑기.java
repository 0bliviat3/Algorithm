import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ2660Sol().run();
    }
}

class BOJ2660Sol {
    private static final String END = "-1 -1";
    private int[][] edges;
    private List<Integer> group;
    private int n;
    
    private void clear() {
        group = new ArrayList<>();
        edges = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j) {
                    continue;
                }
                edges[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    private void init() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        n = Integer.parseInt(in.readLine());
        clear();
        while(!(input = in.readLine()).equals(END)) {
            StringTokenizer st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a][b] = edges[b][a] = 1;
        }     
    }

    private void floyd() {
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    edges[i][j] = min(edges[i][j], edges[i][k], edges[k][j]);
                }
            }
        }
    }

    private int min(int cur, int start, int end) {
        if(start == Integer.MAX_VALUE || end == Integer.MAX_VALUE) {
            return cur;
        }
        return Math.min(cur, start + end);
    }

    private int calMinVal() {       
        int max = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            int min = 0;
            for(int j = 1; j <= n; j++) {
                min = Math.max(min, edges[i][j]);
            }
            if(max > min) {
                max = min;
                group.clear();
                group.add(i);
            }else if(max == min) {
                group.add(i);
            }
        }
        return max;
    }

    private void printAns() {
        StringBuilder ans = new StringBuilder();
        final char EMPTY = ' ';
        ans.append(calMinVal()).append(EMPTY).append(group.size()).append('\n');
        for(int i : group) {
            ans.append(i).append(EMPTY);
        }
        System.out.print(ans);
    }

    void run() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
        floyd();
        printAns();
    }


}
