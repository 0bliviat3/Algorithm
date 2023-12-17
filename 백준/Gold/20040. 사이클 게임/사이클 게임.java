import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BOJ20040Sol instance = new BOJ20040Sol();
		instance.run();
	}

}

class BOJ20040Sol {
	
	private int[] parent;
	
	private void clear(int n) {
		parent = new int[n];
		for(int i = 1; i < n; i++) {
			parent[i] = i;
		}
	}
	
	private int getParent(int child) {
		if(parent[child] == child) {
			return child;
		}
		return parent[child] = getParent(parent[child]);
	}
	
	private void union(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		if(a < b) {
			parent[b] = a;
			return;
		}
		parent[a] = b;
	}
	
	private boolean isCycle(int a, int b) {
		return getParent(a) == getParent(b);
	}
	
	private void process() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		clear(n);
		
		int ans = 0;
		for(int turn = 1; turn <= m; turn++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(isCycle(a, b)) {
				ans = turn;
				break;
			}
			union(a, b);
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
