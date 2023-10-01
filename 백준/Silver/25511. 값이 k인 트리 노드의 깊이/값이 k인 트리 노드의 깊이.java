import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m;
	static ArrayList<Integer>[] edges;
	static int[] data;
	static boolean[] visit;
	
	@SuppressWarnings("unchecked")
	static void clear() {
		edges = new ArrayList[n];
		data = new int[n];
		visit = new boolean[n];
		for(int i = 0; i < n; i++) {
			edges[i] = new ArrayList<>();
		}
	}
	
	static void init(int a, int b) {
		edges[a].add(b);
		edges[b].add(a);
	}
	
	static void dfs(int node, int depth) {
		if(visit[node]) return;
		if(data[node] == m) {
			System.out.print(depth);
			System.exit(0);
		}
		visit[node] = true;
		for(int edge : edges[node]) {
			if(!visit[edge]) {
				dfs(edge,depth + 1);
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		clear();
		
		for(int i = 1; i < n; i++) {
			 st = new StringTokenizer(in.readLine()," ");
			 int a = Integer.parseInt(st.nextToken());
			 int b = Integer.parseInt(st.nextToken());
			 init(a,b);
		}
		st = new StringTokenizer(in.readLine()," ");
		for(int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		in.close();
		
		dfs(0,0);
		
	}

}
