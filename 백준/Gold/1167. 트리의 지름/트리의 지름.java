import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BOJ1167Sol instance = new BOJ1167Sol();
		instance.run();
	}

}

class Node1167 {

	int no;
	int dist;

	Node1167(int no, int dist) {
		this.no = no;
		this.dist = dist;
	}
}

class BOJ1167Sol {

	private List<Node1167>[] edges;
	private boolean[] visit;
	private Node1167 maxNode;

	@SuppressWarnings("unchecked")
	private void clear(int n) {
		maxNode = new Node1167(0, 0);
		edges = new List[n + 1];
		visit = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			edges[i] = new ArrayList<>();
		}
	}

	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());

		clear(n);

		while (n-- > 0) {
			init(in.readLine());
		}
	}

	private void init(String input) {
		StringTokenizer st = new StringTokenizer(input, " ");
		int idx = Integer.parseInt(st.nextToken());
		String token;
		while (!(token = st.nextToken()).equals("-1")) {
			int no = Integer.parseInt(token);
			int dist = Integer.parseInt(st.nextToken());
			edges[idx].add(new Node1167(no, dist));
		}
	}

	private void dfs(int no, int dist) {
		if (maxNode.dist < dist) {
			maxNode.dist = dist;
			maxNode.no = no;
		}
		visit[no] = true;
		for (Node1167 next : edges[no]) {
			if (visit[next.no]) {
				continue;
			}
			dfs(next.no, dist + next.dist);
		}
	}

	private void dfsProcess() {
		dfs(1, 0);
		Arrays.fill(visit, false);
		dfs(maxNode.no, 0);
		System.out.print(maxNode.dist);
	}

	void run() {
		try {
			init();
			dfsProcess();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
