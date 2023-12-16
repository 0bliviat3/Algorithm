import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BOJ1865Sol instance = new BOJ1865Sol();
		instance.run();
	}

}

class Node1865 {

	int start;
	int end;
	int dist;

	Node1865(int start, int end, int dist) {
		this.start = start;
		this.end = end;
		this.dist = dist;
	}
}

@FunctionalInterface
interface TriIntConsumer {
	void accept(int s, int e, int t);
}

class BOJ1865Sol {

	private int[][] metrix;
	private List<Node1865> edges;
	
	private void clear(int n) {
		metrix = new int[n + 1][n + 1];
		edges = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			Arrays.fill(metrix[i], Integer.MAX_VALUE);
		}
	}
	
	private void initMetrix(String input, TriIntConsumer triconsumer) {
		StringTokenizer st = new StringTokenizer(input, " ");
		int s = Integer.parseInt(st.nextToken()) - 1;
		int e = Integer.parseInt(st.nextToken()) - 1;
		int t = Integer.parseInt(st.nextToken());
		
		triconsumer.accept(s, e, t);
	}
	
	private void connectWay(int s, int e, int t) {
		metrix[s][e] = metrix[e][s] = Math.min(metrix[s][e], t);
	}
	
	private void connectHole(int s, int e, int t) {
		metrix[s][e] = -t;
	}
	
	private void process() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(in.readLine());
		while(tc-- > 0) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			clear(n);
			while(m-- > 0) {
				initMetrix(in.readLine(), this::connectWay);
			}
			while(w-- > 0) {
				initMetrix(in.readLine(), this::connectHole);
			}
			for(int i = 0; i <= n; i++) {
				for(int j = 0; j <= n; j++) {
					edges.add(new Node1865(i, j, metrix[i][j]));
				}
			}
			sb.append(bellmanFord(n));
		}
		System.out.print(sb);
	}

	private String bellmanFord(int n) {
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[n] = 0;
		for (int i = 0; i <= n; i++) {
			for (Node1865 node : edges) {
				int current = node.start;
				int next = node.end;
				int cost = node.dist;

				if (dist[current] == Integer.MAX_VALUE) {
					continue;
				}

				if (dist[next] > dist[current] + cost) {
					dist[next] = dist[current] + cost;

					if (i == n) {
						return "YES\n";
					}
				}
			}
		}
		return "NO\n";
	}
	
	void run() {
		try {
			process();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}