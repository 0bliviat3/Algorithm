import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ9370Sol().run();
    }    
}

class Node9370 implements Comparable<Node9370>{
    int end;
    double dist;
    boolean pass;

    Node9370(int end, double dist, boolean pass) {
        this.end = end;
        this.dist = dist;
        this.pass = pass;
    }

    @Override
    public int compareTo(Node9370 o) {
        if(this.dist == o.dist) {
            if(o.pass) {
                return 1;
            }else if(this.pass) {
                return -1;
            }
        }
        if(this.dist < o.dist) {
            return -1;
        }
        return 1;
    }
}

class Dist9370 {
    double dist;
    boolean pass;

    Dist9370(double dist) {
        this.dist = dist;
    }

}

class BOJ9370Sol {

    /*
     * 데이크스트라로 모든 교차로의 최단경로 구하기
     * 이때 경유도로를 거치지 않는 경우를 제외
     */

    private Dist9370[] distances;
    private List<List<Node9370>> graph;
    private List<Integer> ansList;

    private void claer(int n) {
        distances = new Dist9370[n + 1];
        if(graph == null) {
            graph = new ArrayList<>();
        }
        if(ansList == null) {
            ansList = new ArrayList<>();
        }
        graph.clear();
        ansList.clear();
        for(int i = 0; i <= n; i++) {
            distances[i] = new Dist9370(Integer.MAX_VALUE);
            graph.add(new ArrayList<>());
        }
    }

    private boolean biCompare(int s, int e, int g, int h) {
        if(s == g && e == h) {
            return true;
        }else if(s == h && e == g) {
            return true;
        }
        return false;
    }

    private void dijkstra(int start, int g, int h) {
        PriorityQueue<Node9370> heap = new PriorityQueue<>();
        distances[start].dist = 0;
        heap.add(new Node9370(start, 0, false));
        while(!heap.isEmpty()) {
            Node9370 node = heap.remove();

            if(distances[node.end].dist < node.dist) {
                continue;
            }
            for(Node9370 next : graph.get(node.end)) {
                double dist = node.dist + next.dist;
                boolean pass = biCompare(node.end, next.end, g, h) || node.pass;
                if(dist < distances[next.end].dist) {
                    distances[next.end].pass = pass;
                    distances[next.end].dist = dist;
                    heap.add(new Node9370(next.end, dist, pass));
                }
            }
        }
    }

    private void initGraph(String input, int g, int h) {
        StringTokenizer st = new StringTokenizer(input, " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        double dist = Integer.parseInt(st.nextToken());
        boolean pass = biCompare(start, end, g, h);
        if(pass) {
            dist -= 0.5;
        }
        graph.get(start).add(new Node9370(end, dist, pass));
        graph.get(end).add(new Node9370(start, dist, pass));
    }

    private void process() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int testCase = Integer.parseInt(in.readLine());
        while(testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            claer(n);
            while(m-- > 0) {
                initGraph(in.readLine(), g, h);
            }
            dijkstra(start, g, h);
            while(t-- > 0) {
                int goal = Integer.parseInt(in.readLine());
                if(distances[goal].pass) {
                    ansList.add(goal);
                }
            }
            Collections.sort(ansList);
            for(int i : ansList) {
                ans.append(i).append(' ');
            }
            ans.append('\n');
        }
        System.out.print(ans);
    }

    void run() {
        try {
            process();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}