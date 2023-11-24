import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BOJ1967Sol instance = new BOJ1967Sol();
		instance.run();
	}

}

class BOJ1967Node {

	int end;
	int dist;

	BOJ1967Node(int end, int dist) {
		this.end = end;
		this.dist = dist;
	}

}

class BOJ1967Sol {

	private List<BOJ1967Node>[] edges;

	private int n;

	@SuppressWarnings("unchecked")
	private void clear() {
		edges = new List[n + 1];
		for (int i = 1; i <= n; i++) {
			edges[i] = new ArrayList<>();
		}
	}

	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(in.readLine());
		clear();

		for(int i = 1; i < n; i++) {
			init(in.readLine());
		}
	}

	private void init(String input) {
		StringTokenizer st = new StringTokenizer(input, " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int dist = Integer.parseInt(st.nextToken());

		edges[start].add(new BOJ1967Node(end, dist));
		edges[end].add(new BOJ1967Node(start, dist));
	}

	private BOJ1967Node bfs(int start, BOJ1967Node target) {
		Queue<BOJ1967Node> queue = new LinkedList<>();
		boolean[] visit = new boolean[n + 1];
		queue.add(new BOJ1967Node(start, 0));
		visit[start] = true;

		while (!queue.isEmpty()) {
			BOJ1967Node node = queue.remove();
			for (BOJ1967Node next : edges[node.end]) {
				if (visit[next.end]) {
					continue;
				}
				visit[next.end] = true;
				int nextDist = next.dist + node.dist;
				BOJ1967Node nextNode = new BOJ1967Node(next.end, nextDist);
				queue.add(nextNode);
				if (target.dist < nextDist) {
					target = nextNode;
				}
			}
		}
		return target;
	}

	private int getMax() {
		BOJ1967Node node = bfs(1, new BOJ1967Node(1, 0));
		node = bfs(node.end, new BOJ1967Node(node.end, 0));
		return node.dist;
	}

	void run() {
		try {
			init();
			System.out.print(getMax());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}