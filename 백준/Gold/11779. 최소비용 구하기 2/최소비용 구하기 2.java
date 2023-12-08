import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {
		BOJ11779Sol instance = new BOJ11779Sol();
		instance.run();
	}

}

class BOJ11779Sol {
	
	private List<List<Node11779>> edges;
	private int n, start, end;
	
	private void clear() {
		edges = new ArrayList<>();
		for(int i = 0; i <= n; i++) {
			edges.add(new ArrayList<>());
		}
	}
	
	private void init() {
		BufferedReader in = new BufferedReader(
				new InputStreamReader(System.in));
		try {
			n = Integer.parseInt(in.readLine());
			int m = Integer.parseInt(in.readLine());
			clear();
			
			while(m-- > 0) {
				init(in.readLine());
			}
			
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void init(String input) {
		StringTokenizer st = new StringTokenizer(input, " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int cost = Integer.parseInt(st.nextToken());
		
		edges.get(start).add(new Node11779(end, cost));
	}
	
	private void printAns() {
		StringBuilder ans = new StringBuilder();
		List<Integer> route = new ArrayList<>();
		Dijk11779 dijk = new Dijk11779(edges);
		Node11779[] costs = dijk.dijkstra(
				new Node11779(start, 0), n);
		int now = end;
		int cnt = 1;
		route.add(end);
		if(start != end) {
			while(costs[now].end != start) {
				route.add(costs[now].end);
				now = costs[now].end;
				cnt++;
			}
			route.add(start);
			cnt++;
		}
		ans
		.append(costs[end].cost)
		.append('\n')
		.append(cnt)
		.append('\n');
		
		int size = route.size();
		
		for(int i = size - 1; i >= 0; i--) {
			ans.append(route.get(i)).append(' ');
		}
		
		System.out.print(ans);
	}
	
	void run() {
		init();
		printAns();
	}
	
}

class Node11779 implements Comparable<Node11779>{
	int end;
	int cost;
	
	Node11779(int end, int cost) {
		this.end = end;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node11779 o) {
		return this.cost - o.cost;
	}
}

class Dijk11779 {
	
	private final List<List<Node11779>> edges;
	
	Dijk11779(final List<List<Node11779>> edges) {
		this.edges = edges;
	}
	
	private Node11779[] fillINF(int n, int start) {
		Node11779[] arr = new Node11779[n + 1];
		for(int i = 1; i <= n; i++) {
			arr[i] = new Node11779(start, Integer.MAX_VALUE);
		}
		return arr;
	}
	
	Node11779[] dijkstra(Node11779 start, int n) {
		PriorityQueue<Node11779> heap = new PriorityQueue<>();
		Node11779[] costs = fillINF(n, start.end);
		costs[start.end].cost = start.cost;
		heap.add(start);
		
		while(!heap.isEmpty()) {
			Node11779 node = heap.remove();
			
			if(costs[node.end].cost < node.cost) {
				continue;
			}
			
			for(Node11779 next : edges.get(node.end)) {
				int cost = next.cost + node.cost;
				if(costs[next.end].cost > cost) {
					costs[next.end].cost = cost;
					costs[next.end].end = node.end;
					heap.add(new Node11779(next.end, cost));
				}
			}
		}
		return costs;
	}
	
}