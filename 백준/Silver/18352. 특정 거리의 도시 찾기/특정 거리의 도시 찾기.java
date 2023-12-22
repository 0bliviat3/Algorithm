import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		new BOJ18352Sol().run();
	}

}

class BOJ18352Sol {

	private List<List<Integer>> edges;
	private int[] dist;

	private void clear(int n) {
		edges = new ArrayList<>();
		dist = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			edges.add(new ArrayList<>());
		}
	}

	private void process() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		clear(n);
		while (m-- > 0) {
			init(in.readLine());
		}

		bfs(x);
		printAns(k, n);
	}

	private void init(String input) {
		StringTokenizer st = new StringTokenizer(input, " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		edges.get(start).add(end);
	}

	private void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		dist[start] = 1;
		while (!queue.isEmpty()) {
			int edge = queue.remove();
			for (int next : edges.get(edge)) {
				if (dist[next] == 0) {
					dist[next] = dist[edge] + 1;
					queue.add(next);
				}
			}
		}
	}

	private void printAns(int k, int n) {
		++k;
		boolean flag = true;
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i <= n; i++) {
			if (dist[i] == k) {
				flag = false;
				ans.append(i).append('\n');
			}
		}
		if (flag) {
			ans.append(-1);
		}
		System.out.print(ans);
	}

	void run() {
		try {
			process();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
