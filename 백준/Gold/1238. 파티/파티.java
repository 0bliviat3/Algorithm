import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BOJ1238Sol instance = new BOJ1238Sol();
		instance.run();
	}

}

class Node1238 implements Comparable<Node1238>{
	
	int end;
	int dist;
	
	Node1238(int end, int dist) {
		this.end = end;
		this.dist = dist;
	}

	@Override
	public int compareTo(Node1238 o) {
		return this.dist - o.dist;
	}
	
}

class Dijkstra1238 {
	
	private final List<Node1238>[] edges;
	private final int[] distances;
	
	Dijkstra1238(final List<Node1238>[] edges, final int[] distances) {
		this.edges = edges;
		this.distances = distances;
	}
	
	void dijkstra(int start) {
		PriorityQueue<Node1238> heap = new PriorityQueue<>();
		heap.add(new Node1238(start, 0));
		distances[start] = 0;
		
		while(!heap.isEmpty()) {
			Node1238 node = heap.remove();
			if(distances[node.end] < node.dist) {
				continue;
			}
			for(Node1238 next : edges[node.end]) {
				int distance = next.dist + node.dist;
				if(distances[next.end] > distance) {
					distances[next.end] = distance;
					heap.add(new Node1238(next.end, distance));
				}
			}
		}
	}
	
}

class BOJ1238Sol {
	
	private List<Node1238>[] edges;
	private List<Node1238>[] reverseEdges;
	private int[] distances;
	private int[] reverseDistances;
	
	@SuppressWarnings("unchecked")
	private void clear(int n) {
		edges = new List[n + 1];
		reverseEdges = new List[n + 1];
		distances = new int[n + 1];
		reverseDistances = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			edges[i] = new ArrayList<>();
			reverseEdges[i] = new ArrayList<>();
			distances[i] = Integer.MAX_VALUE;
			reverseDistances[i] = Integer.MAX_VALUE;
		}
	}
	
	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		clear(n);
		
		while(m-- > 0) {
			init(in.readLine());
		}
		
		solve(x, n);
	}
	
	private void init(String input) {
		StringTokenizer st = new StringTokenizer(input," ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int dist = Integer.parseInt(st.nextToken());
		
		edges[start].add(new Node1238(end, dist));
		reverseEdges[end].add(new Node1238(start, dist));
	}
	
	private void solve(int x, int n) {
		
		new Dijkstra1238(edges, distances).dijkstra(x);
		new Dijkstra1238(reverseEdges, reverseDistances).dijkstra(x);
		
		System.out.print(
				calculateMax(n, distances, reverseDistances));
	}
	
	private int calculateMax(int n, int[] distances, int[] reverseDistances) {
		int max = 0;
		for(int i = 1; i <= n; i++) {
			distances[i] += reverseDistances[i];
			max = Math.max(distances[i], max);
		}
		return max;
	}
	
	void run() {
		try {
			init();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}