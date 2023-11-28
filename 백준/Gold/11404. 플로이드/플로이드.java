import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BOJ11404Sol instance = new BOJ11404Sol();
		instance.run();
	}

}

class BOJ11404Sol {
	
	private int[][] edges;
	
	private void clear(int n) {
		edges = new int[n + 1][n + 1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(i == j) {
					continue;
				}
				edges[i][j] = Integer.MAX_VALUE;
			}
		}
	}
	
	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int m = Integer.parseInt(in.readLine());
		
		clear(n);
		
		while(m-- > 0) {
			init(in.readLine());
		}
		
		floydWarshall(n);
		printEdges(n);
	}
	
	private void init(String input) {
		StringTokenizer st = new StringTokenizer(input, " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int dist = Integer.parseInt(st.nextToken());
		
		edges[start][end] = Math.min(edges[start][end], dist);
	}
	
	private void floydWarshall(int n) {	
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					edges[i][j] = min(edges[i][j], edges[i][k], edges[k][j]);
				}
			}
		}
	}
	
	private int min(int current, int start, int end) {
		if(start == Integer.MAX_VALUE || end == Integer.MAX_VALUE) {
			return current;
		}
		return Math.min(current, start + end);
	}
	
	private int calINF(int val) {
		if(val == Integer.MAX_VALUE) {
			return 0;
		}
		return val;
	}
	
	private void printEdges(int n) {
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				sb.append(calINF(edges[i][j])).append(' ');
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
	
	void run() {
		try {
			init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
