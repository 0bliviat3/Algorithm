import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	/*
	 * n - 1 을 제외한 1인 분기점은 탐색 경로에서 제외한다. 
	 */

	public static void main(String[] args) {
		new BOj17396Sol().run();
	}

}

class Node implements Comparable<Node>{
	int node;
	long value;
	
	Node(int node, long value) {
		this.node = node;
		this.value = value;
	}

	@Override
	public int compareTo(Node o) {
		if(this.value < o.value) {
			return -1;
		}else if(this.value == o.value) {
			return 0;
		}
		return 1;
	}
}

class Node17396 extends Node {

	Node17396(int node, long value) {
		super(node, value);
	}
	
}

class Dijk17396 <T extends Node>{
	
	private static final int START_VAL = 0;
	
	private final List<List<T>> edges;
	
	Dijk17396(final List<List<T>> edges) {
		this.edges = edges;
	}
	
	long dijkstra(int start, boolean[] sight) {
		PriorityQueue<T> heap = new PriorityQueue<>();
		int size = edges.size();
		long[] values = new long[size];
		Arrays.fill(values, Long.MAX_VALUE);
		values[start] = START_VAL;
		heap.add((T) new Node(start , START_VAL));
		while(!heap.isEmpty()) {
			T node = heap.remove();
			
			if(values[node.node] < node.value) {
				continue;
			}
			
			if(sight[node.node]) {
				continue;
			}
			
			for(T next : edges.get(node.node)) {
				
				long nextVal = next.value + node.value;
				
				if(values[next.node] > nextVal) {
					values[next.node] = nextVal;
					heap.add((T) new Node(next.node, nextVal));
				}
			}
		}
		return values[size - 1];
	}	
}

class BOj17396Sol {
	
	private static final String WARD = "1";
	private List<List<Node17396>> edges;
	private boolean[] sight;
	
	private void clear(int n) {
		edges = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			edges.add(new ArrayList<>());
		}
		sight = new boolean[n];
	}
	
	private void initSight(String input, int n) {
		StringTokenizer st = new StringTokenizer(input, " ");
		for(int i = 0; i < n ; i++) {
			sight[i] = st.nextToken().equals(WARD);
		}
	}
	
	private void initEdges(String input) {
		StringTokenizer st = new StringTokenizer(input, " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		edges.get(a).add(new Node17396(b, t));
		edges.get(b).add(new Node17396(a, t));
	}
	
	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		clear(n);
		
		initSight(in.readLine(), n);
		
		while(m-- > 0) {
			initEdges(in.readLine());
		}
	}
	
	private void printAns() {
		long time = new Dijk17396(edges)
				.dijkstra(0, sight);
		if(time == Long.MAX_VALUE) {
			System.out.print(-1);
			return;
		}
		System.out.print(time);
	}
	
	void run() {
		try {
			init();
		} catch (IOException e) {
			e.printStackTrace();
		}
		printAns();
	}
	
}