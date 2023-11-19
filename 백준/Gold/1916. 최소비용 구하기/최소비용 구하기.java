import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		BOJ1916Sol instance = new BOJ1916Sol(
				new ArrayList[1001], new int[1001], new boolean[1001]);
		instance.run();
	}

}

class BOJ1916Sol {

	private final List<Point>[] edges;
	private final int[] costs;
	private final boolean[] visit;

	BOJ1916Sol(final List<Point>[] edges, final int[] costs, final boolean[] visit) {
		this.edges = edges;
		this.costs = costs;
		this.visit = visit;
	}

	void run() {
		try {
			init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void clear() {
		Arrays.fill(costs, Integer.MAX_VALUE);
		for(int i = 0; i < 1001; i++) {
			edges[i] = new ArrayList<>();
		}
	}

	private void init() throws IOException {
		clear();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in.readLine();
		int busCnt = Integer.parseInt(in.readLine());
		while (busCnt-- > 0) {
			addBus(in.readLine());
		}
		setRange(in.readLine());
	}

	private void addBus(String info) {
		StringTokenizer st = new StringTokenizer(info, " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int cost = Integer.parseInt(st.nextToken());

		edges[start].add(new Point(end, cost));
	}

	private void setRange(String range) {
		StringTokenizer st = new StringTokenizer(range, " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		dijkstra(start);
		printCost(end);
	}

	private void dijkstra(int start) {
		costs[start] = 0;
		PriorityQueue<Point> heap = new PriorityQueue<>((o1, o2) -> o1.y - o2.y);
		heap.add(new Point(start, 0));

		while (!heap.isEmpty()) {
			Point now = heap.remove();

			if(visit[now.x]) {
				continue;
			}
			
			visit[now.x] = true;

			for(Point node : edges[now.x]) {
				int cost = costs[now.x] + node.y;
				if(costs[node.x] > cost) {
					costs[node.x] = cost;
					heap.add(new Point(node.x, cost));
				}
			}
		}
	}

	private void printCost(int end) {
		System.out.print(costs[end]);
	}
}
