import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ10423Sol(new UnionFindCity()).run();
    }
}

class Edge10423 implements Comparable<Edge10423> {
    int cityA;
    int cityB;
    int cost;

    Edge10423(int cityA, int cityB, int cost) {
        this.cityA = cityA;
        this.cityB = cityB;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge10423 o) {
        return this.cost - o.cost;
    }
}

class City {
    int cityNo;
    boolean isPower;

    City(int cityNo, boolean isPower) {
        this.cityNo = cityNo;
        this.isPower = isPower;
    }
}

class UnionFindCity {
    
    private List<Integer> parent;

    void clear(int n) {
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

    void initCable(String input, int k) {
        StringTokenizer st = new StringTokenizer(input, " ");
        for(int i = 0; i < k; i++) {
            parent.set(Integer.parseInt(st.nextToken()), 0);
        }
    }

    boolean union(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if(a != b) {
            if(a == 0) {
                parent.set(b, a);
            } else {
                parent.set(a, b);
            }
            return true;
        }
        return false;
    }
}

class BOJ10423Sol {
    /*
     * 발전소가 설치된 도시는 연결하지 않아도 됨
     * 노드에 발전소가 설치되었는지에 대한 상태를 저장
     * 크루스칼 알고리즘을 사용해 연결한다.
     * 이때 연결할 도시둘다 발전소가 설치되어있는 상태라면 연결되어있지 않더라도
     * 연결하지 않고 넘어간다.
     * 종료조건) 전체 도시의 수 - 발전기가 설치된 도시의 수 == 연결횟수
     */

    private static final String EMPTY = " ";
    private final UnionFindCity unionFindCity;
    private List<Edge10423> edges;

    BOJ10423Sol(final UnionFindCity unionFindCity) {
        this.unionFindCity = unionFindCity;
        edges = new ArrayList<>();
    }

    private void init() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), EMPTY);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        unionFindCity.clear(n);
        unionFindCity.initCable(in.readLine(), k);
        while(m-- > 0) {
            initEdge(in.readLine());
        }
        System.out.println(kruskal(n - k));
    }

    private void initEdge(String input) {
        StringTokenizer st = new StringTokenizer(input, EMPTY);
        int cityA = Integer.parseInt(st.nextToken());
        int cityB = Integer.parseInt(st.nextToken());
        int cost = Integer.parseInt(st.nextToken());
        edges.add(new Edge10423(cityA, cityB, cost));
    }

    private int kruskal(int n) {
        int cnt = 0;
        int sum = 0;
        Collections.sort(edges);
        for(Edge10423 edge : edges) {
            if(cnt == n) {
                return sum;
            }
            if(unionFindCity.union(edge.cityA, edge.cityB)) {
                cnt++;
                sum += edge.cost;
            }
        }
        return sum;
    }

    void run() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}

