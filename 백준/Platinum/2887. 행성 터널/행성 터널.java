import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractQueue;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ2887Sol_2().run();
    }
}

class Planet {
    int no;
    int x;
    int y;
    int z;

    Planet(int no, int x, int y, int z) {
        this.no = no;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    private int min(int x, int y, int z) {
        x = Math.min(x, y);
        return Math.min(x, z);
    }

    int getCost(Planet planet) {
        int x = Math.abs(this.x - planet.x);
        int y = Math.abs(this.y - planet.y);
        int z = Math.abs(this.z - planet.z);
        return min(x, y, z);
    }

    public int compareX(Planet planet) {
        return this.x - planet.x;
    }

    public int compareY(Planet planet) {
        return this.y - planet.y;
    }

    public int compareZ(Planet planet) {
        return this.z - planet.z;
    }
}

class Tunnel implements Comparable<Tunnel> {
    int planetA;
    int planetB;
    int cost;

    Tunnel(int planetA, int planetB, int cost) {
        this.planetA = planetA;
        this.planetB = planetB;
        this.cost = cost;
    }

    @Override
    public int compareTo(Tunnel o) {
        return this.cost - o.cost;
    }
}

class BOJ2887Sol_2 {
    private AbstractQueue<Tunnel> heap;
    private AbstractQueue<Planet> planetsX;
    private AbstractQueue<Planet> planetsY;
    private AbstractQueue<Planet> planetsZ;
    private int[] parent;

    private void clear(int n) {
        heap = new PriorityQueue<>();
        planetsX = new PriorityQueue<>(Planet::compareX);
        planetsY = new PriorityQueue<>(Planet::compareY);
        planetsZ = new PriorityQueue<>(Planet::compareZ);
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    private void initPlanet(String input, int no) {
        StringTokenizer point = new StringTokenizer(input);
        int x = Integer.parseInt(point.nextToken());
        int y = Integer.parseInt(point.nextToken());
        int z = Integer.parseInt(point.nextToken());
        planetsX.add(new Planet(no, x, y, z));
        planetsY.add(new Planet(no, x, y, z));
        planetsZ.add(new Planet(no, x, y, z));
    }

    private int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
            return true;
        }
        return false;
    }

    private void setCost(AbstractQueue<Planet> planetQueue) {
        Planet planet = planetQueue.poll();
        while(!planetQueue.isEmpty()) {
            Planet planet2 = planetQueue.poll();
            heap.add(
                new Tunnel(planet.no, planet2.no,
                        planet.getCost(planet2)));
            planet = planet2;
        }
    }

    private long kruskal(int n) {
        long cost = 0L;
        int cnt = 0;
        while (!heap.isEmpty()) {
            Tunnel tunnel = heap.poll();
            if (union(tunnel.planetA, tunnel.planetB)) {
                cnt++;
                cost += tunnel.cost;
            }
            if (cnt == n) {
                return cost;
            }
        }
        return cost;
    }

    private void solve() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        clear(n);
        for (int i = 1; i <= n; i++) {
            initPlanet(in.readLine(), i);
        }
        setCost(planetsX);
        setCost(planetsY);
        setCost(planetsZ);
        System.out.print(kruskal(n));
    }

    void run() {
        try {
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
