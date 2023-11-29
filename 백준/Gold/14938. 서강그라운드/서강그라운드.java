import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BOJ14938Sol instance = new BOJ14938Sol();
		instance.run();
	}
	
}

class Node14938 {

	int end;
	int dist;

	Node14938(int end, int dist) {
		this.end = end;
		this.dist = dist;
	}
}

class BOJ14938Sol {

	private int[] items;
	private int[][] distances;

	private void clear(int n) {
		distances = new int[n + 1][n + 1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(i == j) {
					continue;
				}
				distances[i][j] = Integer.MAX_VALUE;
			}
		}
	}

	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		clear(n);
		
		initItem(n, in.readLine());
		
		while(r-- > 0) {
			initDist(in.readLine());
		}
		
		floydWarshall(n);
		System.out.print(calMaxItems(n, m));
	}
	
	private void initItem(int n, String itemInfo) {
		StringTokenizer st = new StringTokenizer(itemInfo, " ");
		items = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	private void initDist(String distInfo) {
		StringTokenizer st = new StringTokenizer(distInfo, " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int dist = Integer.parseInt(st.nextToken());
		
		distances[start][end] = distances[end][start] = dist;
	}
	
	private void floydWarshall(int n) {
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					distances[i][j] = calMin(distances[i][j], distances[i][k], distances[k][j]);
				}
			}
		}
	}
	
	private int calMin(int a, int b, int c) {
		if(b == Integer.MAX_VALUE || c == Integer.MAX_VALUE) {
			return a;
		}
		return Math.min(a, b + c);
	}
	
	private int calMaxItems(int n, int m) {
		int ans = 0;
		for(int i = 1; i <= n; i++) {
			int max = 0;
			for(int j = 1; j <= n; j++) {
				if(distances[i][j] <= m) {
					max += items[j];
				}
			}
			ans = Math.max(ans, max);
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