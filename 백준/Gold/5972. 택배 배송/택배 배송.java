import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BOJ5972Sol instance = new BOJ5972Sol();
		instance.run();
	}

}

class BOJ5972Node implements Comparable<BOJ5972Node>{

	final int end;
	final int fodder;

	BOJ5972Node(final int end, final int fodder) {
		this.end = end;
		this.fodder = fodder;
	}

	@Override
	public int compareTo(BOJ5972Node o) {
		return this.fodder - o.fodder;
	}
}

class BOJ5972Sol {

	private static final int DEFAULT = 0;
	private static final int CORRECTION = 1;

	private List<BOJ5972Node>[] edges;
	private int[] feedCost;

	private int n;

	@SuppressWarnings("unchecked")
	private void clear() {
		edges = new ArrayList[n];
		feedCost = new int[n];
		for (int i = 1; i < n; i++) {
			feedCost[i] = Integer.MAX_VALUE;
			edges[i] = new ArrayList<>();
		}
	}

	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		n = Integer.parseInt(st.nextToken()) + CORRECTION;
		int m = Integer.parseInt(st.nextToken());

		clear();

		while (m-- > DEFAULT) {
			init(in.readLine());
		}
	}

	private void init(String input) {
		StringTokenizer st = new StringTokenizer(input, " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int fodder = Integer.parseInt(st.nextToken());
		edges[start].add(new BOJ5972Node(end, fodder));
		edges[end].add(new BOJ5972Node(start, fodder));
	}

	private void dijkstra(int start) {
		PriorityQueue<BOJ5972Node> heap = new PriorityQueue<>();
		heap.add(new BOJ5972Node(start, DEFAULT));
		feedCost[start] = DEFAULT;

		while (!heap.isEmpty()) {
			BOJ5972Node node = heap.remove();

			if (feedCost[node.end] < node.fodder) {
				continue;
			}

			for (BOJ5972Node next : edges[node.end]) {
				int fodder = next.fodder + node.fodder;
				if (feedCost[next.end] > fodder) {
					feedCost[next.end] = fodder;
					heap.add(new BOJ5972Node(next.end, fodder));
				}
			}
		}
	}

	private void printMinFodder() {
		System.out.print(feedCost[n - CORRECTION]);
	}

	void run() {
		try {
			init();
			dijkstra(CORRECTION);
			printMinFodder();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}