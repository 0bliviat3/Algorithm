import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractQueue;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        new BOJ17472Sol(new UnionFind(), new PriorityQueue<>()).run();
    }

}

class Edge17472 implements Comparable<Edge17472> {
    int start;
    int end;
    int dist;

    Edge17472(int start, int end, int dist) {
        this.start = start;
        this.end = end;
        this.dist = dist;
    }

    @Override
    public int compareTo(Edge17472 o) {
        return this.dist - o.dist;   
    }
}

class BOJ17472Sol {

    /*
     * 섬을 묶어서 생각하기 보다 한칸한칸 다 따로 생각
     * 모든 섬사이의 간선을 구해 우선순위큐에 저장
     * 간선은 가중치 1 제외
     * 간선은 직선만 가능
     * 간선 사이에 섬이 있는 경우는 제외
     * union-find로 연결해가며 최소 스패닝 트리 찾기
     */

    private static final int ISLAND = 1;
    private static final int IMPOSSIBLE = -1;
    private final UnionFind unionFind;
    private final AbstractQueue<Edge17472> heap;
    private int[][] metrix;
    private int n, m;

    BOJ17472Sol(
        final UnionFind unionFind,
        final AbstractQueue<Edge17472> heap) {
            this.unionFind = unionFind;
            this.heap = heap;
    }

    void run() {
        try {
            process(init());
        } catch (IOException e) {
            e.printStackTrace();
        }      
    }

    private void clear(String input) {
        StringTokenizer st = new StringTokenizer(input);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        metrix = new int[n][m];
    }

    private int init() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int islandNo = 0;
        clear(in.readLine());
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int j = 0; j < m; j++) {
                if(Integer.parseInt(st.nextToken()) == ISLAND) {
                    metrix[i][j] = ++islandNo;
                }
            }
        }
        return islandNo;
    }

    private void process(int cnt) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(metrix[i][j] != 0) {
                    find(i , j);
                }
            }
        }
        unionFind.clear(cnt);
        System.out.print(kruskal(cnt));
    }

    private void find(int i, int j) {   
        int x = i;
        int y = j;
        // 가로탐색
        while(++j < m) {
            if(metrix[x][j] > 0) { // 섬을 만난 경우
                if(j - y != 2) { // 거리가 1인 경우를 제외
                    heap.add(new Edge17472(metrix[x][y], metrix[x][j], j - y - 1));
                }
                break;
            }
        }
        //세로탐색
        while(++i < n) {
            if(metrix[i][y] > 0) {
                if(i - x != 2) {
                    heap.add(new Edge17472(metrix[x][y], metrix[i][y], i - x - 1));
                }
                break;
            }
        }
    }

    private int kruskal(int n) {
        int cnt = 0;
        int dist = 0;
        while(!heap.isEmpty()) {
            Edge17472 edge  = heap.remove();
            
            if(unionFind.union(edge.start, edge.end)) {
                dist += edge.dist;
                // System.out.println("a : " + edge.start + ", b : " + edge.end + " 거리 : " + edge.dist);
                if(++cnt == n - 1) {
                    return dist;
                }
            }
        }
        return IMPOSSIBLE;
    }

    

}

class UnionFind {
    
    private List<Integer> parent;

    public void clear(int n) {
        parent = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            parent.add(i);
        }
    }

    private int getParent(int x) {
        if(parent.get(x) == x) {
            return x;
        }
        parent.set(x, getParent(parent.get(x)));
        return parent.get(x);
    }

    public boolean union(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if(a != b) {
            parent.set(b, a);
            return true;
        }
        return false;
    }
}

