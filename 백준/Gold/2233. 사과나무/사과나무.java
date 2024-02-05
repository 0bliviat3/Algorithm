import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ2233Sol().run();
    }
}

class BOJ2233Sol {
    private static final int NOT_VISIT = -1;
    private static final char DEEP = '0';
    private List<List<Integer>> tree;
    private int[][] table;
    private int[] depths;
    private int[][] binarySite;
    private int n, h;

    private void setH() {
        h = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
    }

    private void clear() {
        setH();
        table = new int[h][n + 1];
        depths = new int[n + 1];
        binarySite = new int[2][n + 1];
        tree = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            depths[i] = NOT_VISIT;
            tree.add(new ArrayList<>());
        }
    }

    private List<Integer> setTree(String binaryArr, String rottenApple) {
        Stack<Integer> stack = new Stack<>();
        char[] arr = binaryArr.toCharArray();
        List<Integer> query = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(rottenApple);
        int rottenA = Integer.parseInt(st.nextToken());
        int rottenB = Integer.parseInt(st.nextToken());

        int idx = 1;
        int node = 1;
        int now = 0;
        int pre = 0;
        stack.push(0);
        for(char bi : arr) {
            if(bi == DEEP) {
                now = node;
                stack.push(node);
                node++;
                tree.get(pre).add(now);
                binarySite[bi - DEEP][now] = idx;
                if(idx == rottenA || idx == rottenB) {
                    query.add(now);
                }
                pre = now;       
            } else {
                now = stack.pop();
                binarySite[bi - DEEP][now] = idx;
                if(idx == rottenA || idx == rottenB) {
                    query.add(now);
                }
                pre = stack.peek();  
            }
            idx++;  
        }
        return query;
    }

    private void dfs(int node, int depth) {
        depths[node] = depth;
        for(int next : tree.get(node)) {
            if(depths[next] > NOT_VISIT) {
                continue;
            }
            table[0][next] = node;
            dfs(next, depth + 1);
        }
    }

    private void setTable() {
        dfs(1, 0);
        for(int k = 1; k < h; k++) {
            for(int i = 1; i <= n; i++) {
                table[k][i] = table[k - 1][table[k - 1][i]];
            }
        }
    }

    private int LCA(int a, int b) {
        if(depths[a] < depths[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        for(int i = h - 1; i >= 0; i--) {
            if(depths[a] - depths[b] >= (1 << i)) {
                a = table[i][a];
            }
        }
        if(a == b) {
            return a;
        }
        for(int i = h - 1; i >= 0; i--) {
            if(table[i][a] != table[i][b]) {
                a = table[i][a];
                b = table[i][b];
            }
        }
        return table[0][a];
    }

    private void process() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        clear();
        String binaryArr = in.readLine();
        String rottenApple = in.readLine();
        List<Integer> query = setTree(binaryArr, rottenApple);

        // debug
        /*
        System.out.println("---binary Table---");
        for(int i = 0; i <= n; i++) {
            System.out.print(binarySite[0][i] + " ");
        }
        System.out.println();
        for(int i = 0; i <= n; i++) {
            System.out.print(binarySite[1][i] + " ");
        }
        System.out.println();
        System.out.println("---end---");

        System.out.println("--tree--");
        for(int i = 0; i <= n; i++) {
            System.out.print(i + " : ");
            for(int j : tree.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println("--end--");
        */


        setTable();
        int node = LCA(query.get(0), query.get(1));
        System.out.print(binarySite[0][node] + " " + binarySite[1][node]);
    }

    void run() {
        try {
            process();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
