import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {
		BOJ2644Sol instance = new BOJ2644Sol();
		instance.close();
	}

}

class BOJ2644Sol {
	
	private ArrayList<Integer>[] edges;
	private boolean[] visit;
	private StringTokenizer st;
	
	BOJ2644Sol() {
		try {
			run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	private void clear(int n) {
		visit = new boolean[n + 1];
		edges = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) { edges[i] = new ArrayList<>(); }
	}
	
	private int[] target(String input) {
		int[] target = new int[2];
		st = new StringTokenizer(input," ");
		target[0] = Integer.parseInt(st.nextToken());
		target[1] = Integer.parseInt(st.nextToken());
		return target;
	}
	
	private void init(String input) {
		st = new StringTokenizer(input," ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		edges[a].add(b);
		edges[b].add(a);
	}
	
	private int dfs(int start, int end, int grade) {
		if(visit[start]) { return -1; }
		if(start == end) { return grade; }
		visit[start] = true;
		for(int edge : edges[start]) {
			int temp = dfs(edge, end, grade + 1);
			if(temp > -1) { return temp; }
		}
		return -1;
	}
	
	private void run() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		clear(n);
		int[] target = target(in.readLine());
		int m = Integer.parseInt(in.readLine());
		while(m-- > 0) { init(in.readLine()); }
		System.out.print(dfs(target[0], target[1], 0));
	}
	
	void close() {
		visit = null;
		edges = null;
		st = null;
	}
	
}
