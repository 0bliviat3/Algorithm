import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {
		BOJ1504Sol instance = new BOJ1504Sol();
		instance.run();
	}

}

class Node1504 implements Comparable<Node1504>{

	int end;
	int dist;
	
	Node1504(int end, int dist) {
		this.end = end;
		this.dist = dist;
	}

	@Override
	public int compareTo(Node1504 o) {
		return this.dist - o.dist;
	}
	
}

class Dijkstra1504 {
	
	private final List<Node1504>[] edges;
	private final int[] distances;
	
	Dijkstra1504(final List<Node1504>[] edges, final int[] distances) {
		this.edges = edges;
		this.distances = distances;
	}
	
	void clear() {
		Arrays.fill(distances, Integer.MAX_VALUE);
	}
	
	void dijkstra(int start) {
		PriorityQueue<Node1504> heap = new PriorityQueue<>();
		heap.add(new Node1504(start, 0));
		distances[start] = 0;
		
		while(!heap.isEmpty()) {
			Node1504 node = heap.remove();
			if(distances[node.end] < node.dist) {
				continue;
			}
			for(Node1504 next : edges[node.end]) {
				int distance = next.dist + node.dist;
				if(distances[next.end] > distance) {
					distances[next.end] = distance;
					heap.add(new Node1504(next.end, distance));
				}
			}
		}
	}
}

class BOJ1504Sol {
	
	private List<Node1504>[] edges;
	private int[] distances;
	
	@SuppressWarnings("unchecked")
	private void clear(int n) {
		edges = new List[n + 1];
		distances = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			edges[i] = new ArrayList<>();
		}
	}
	
	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		clear(n);
		
		while(e-- > 0) {
			initEdge(in.readLine());
		}
		
		initCondition(in.readLine() , n);
	}
	
	private void initEdge(String input) {
		StringTokenizer st = new StringTokenizer(input, " ");
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int dist = Integer.parseInt(st.nextToken());
		
		edges[start].add(new Node1504(end, dist));
		edges[end].add(new Node1504(start, dist));
	}
	
	private void initCondition(String condition, int n) {
		StringTokenizer st = new StringTokenizer(condition, " ");
		int edge1 = Integer.parseInt(st.nextToken());
		int edge2 = Integer.parseInt(st.nextToken());
		
		dijkstraPro(edge1, edge2, n);
	}
	
	private void dijkstraPro(int e1, int e2, int n) {
		Dijkstra1504 dijkstra = new Dijkstra1504(edges, distances);
		dijkstra.clear();
		dijkstra.dijkstra(1);
		
		List<Integer> info = List.of(distances[e1], distances[e2]);
		
		dijkstra.clear();
		dijkstra.dijkstra(n);
		
		List<Integer> info2 = List.of(distances[e2], distances[e1]);
		
		
		dijkstra.clear();
		dijkstra.dijkstra(e1);
		
		int dist = distances[e2];
		
		System.out.print(calDist(info, info2, dist));
	}
	
	private boolean isINF(int val) {
		return val == Integer.MAX_VALUE;
	}
	
	private int calDist(List<Integer> info, List<Integer> info2, int dist) {
		int ans = 0;
		int[] sum = {Integer.MAX_VALUE, Integer.MAX_VALUE};
		for(int i = 0; i < 2; i++) {
			if(!isINF(info.get(i))) {
				if(!isINF(info2.get(i))) {
					if(!isINF(dist)) {
						sum[i] = info.get(i) + info2.get(i) + dist;
					}
				}
			}
		}
		ans = Math.min(sum[0], sum[1]);
		if(isINF(ans)) {
			return -1;
		}
		return ans;	
	}
	
	void run() {
		try {
			init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}