import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) {
        new BOJ3584Sol().run();
    }
}

class BOJ3584Sol {

    private List<List<Integer>> tree;
    private int[] parents;

    private void clear(int n) {
        parents = new int[n + 1];
        tree = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
    }

    void run() {
        try {
            process();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void process() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            clear(n);
            for(int i = 1; i < n; i++) {
                initTree(in.readLine());
            }
            LCA lca = new LCA(tree);
            int h = lca.getHeight(n);
            lca.clear(n, h);
            lca.dfs(getParent(1), 0);
            lca.setParent(n, h);
            StringTokenizer st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ans.append(lca.lca(a, b, h)).append('\n');
        }
        System.out.print(ans);
    }

    private void initTree(String input) {
        StringTokenizer st = new StringTokenizer(input);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        tree.get(a).add(b);
        tree.get(b).add(a);
        parents[b] = a;
    }

    private int getParent(int x) { // 루트 찾기
        if(parents[x] == 0) {
            return x;
        }
        return getParent(parents[x]);
    }
}

class LCA {
    
    private final List<List<Integer>> tree; // 트리
    private int[][] parents; // 각노드의 부모 노드 정보
    private int[] depths; // 각노드의 깊이 정보
    private boolean[] visit; // dfs를 위한 방문 배열

    public LCA(final List<List<Integer>> tree) {
        this.tree = tree;
    }

    public void clear(int n, int h) {
        depths = new int[n + 1];
        visit = new boolean[n + 1];
        parents = new int[n + 1][h];
    }

    /**
     * 트리의 높이 구하기
     * @param n : 노드의 개수
     * @return 높이
     */
    public int getHeight(int n) {
        return (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
    }

    /**
     * 깊이를 저장하고, 윗부모와 연결하는 메소드
     * @param node : 현재 노드
     * @param depth : 깊이
     */
    public void dfs(int node, int depth) {
        visit[node] = true;
        depths[node] = depth;
        for(int next : tree.get(node)) {
            if(visit[next]) {
                continue;
            }
            parents[next][0] = node;
            dfs(next, depth + 1);
        }
    }

    /**
     * 모든 노드의 2^i 번째 부모노드 채우기
     * @param n : 노드의 수
     * @param h : 높이
     */
    public void setParent(int n , int h) {
        for(int j = 1; j < h; j++) {
            for(int i = 1; i <= n; i++) {
                parents[i][j] = parents[parents[i][j - 1]][j - 1];
            }
        }
    }

    /**
     * 두 노드의 최소 공통조상 구하기
     * @param a : 노드1
     * @param b : 노드2
     * @param h : 트리의 높이
     * @return 공통조상
     */
    public int lca(int a, int b, int h) {
        if(depths[a] < depths[b]) { // 더 깊은 노드를 a로 둔다.
            int temp = a;
            a = b;
            b = temp;
        }
        for(int i = h - 1; i >= 0; i--) { // 노드의 깊이를 동일하게 맞추기
            if(depths[a] - depths[b] >= (1 << i)) {
                a = parents[a][i];
            }
        }

        if(a == b) {
            return a;
        }
        for(int i = h - 1; i >= 0; i--) {
            if(parents[b][i] != parents[a][i]) { // 부모노드로 거슬러 올라가기
                a = parents[a][i];
                b = parents[b][i];
            }
        }
        return parents[a][0];
    }



}

