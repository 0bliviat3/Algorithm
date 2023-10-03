import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] edges;
	static boolean[][] apple;
	static StringTokenizer st;
	static int n,k,cnt;
	
	@SuppressWarnings("unchecked")
	static void clear() {
		edges = new ArrayList[n];
		apple = new boolean[n][2];
		for(int i = 0; i < n; i++) {
			edges[i] = new ArrayList<>();
		}
	}
	
	static int nextToken() {
		return Integer.parseInt(st.nextToken());
	}
	
	static void run() throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine()," ");
		n = nextToken();
		k = nextToken();
		clear();
		for(int i = 1; i < n; i++) {
			st = new StringTokenizer(in.readLine()," ");
			init(nextToken(),nextToken());
		}
		st = new StringTokenizer(in.readLine()," ");
		for(int i = 0; i < n; i++) {
			apple[i][0] = nextToken() == 1;
		}
		in.close();
		dfs(0,0);
	}
	
	static void init(int a, int b) {
		edges[a].add(b);
		edges[b].add(a);
	}
	
	static void dfs(int node, int depth) {
		if(apple[node][1]) return;
		apple[node][1] = true;
		if(apple[node][0]) cnt++;
		if(depth == k) return;
		for(int edge : edges[node]) {
			if(!apple[edge][1]) {
				dfs(edge,depth + 1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		run();
		System.out.print(cnt);
	}

}
