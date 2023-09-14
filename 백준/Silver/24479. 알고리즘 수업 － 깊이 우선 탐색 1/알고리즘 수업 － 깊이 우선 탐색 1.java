import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static int n,cnt;
	static int[] visit;
	static ArrayList<Integer>[] edges;
	
	static void setList() {
		edges = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) {
			edges[i] = new ArrayList<Integer>();
		}
	}
	
	static void sorts() {
		for(int i = 1; i <= n; i++) {
			Collections.sort(edges[i]);
		}
	}
	
	static void init(int a, int b) {
		edges[a].add(b);
		edges[b].add(a);
	}
	
	static void dfs(int node) {
		if(visit[node] != 0) return;
		visit[node] = ++cnt;
		for(int i : edges[node]) {
			if(visit[i] == 0) {
				dfs(i);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		visit = new int[n + 1];
		
		setList();
		
		while(m-- > 0) {
			st = new StringTokenizer(in.readLine()," ");
			init(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		in.close();
		
		sorts();
		
		dfs(r);
		
		for(int i = 1; i <= n; i++) {
			sb.append(visit[i]).append('\n');
		}
		
		System.out.print(sb);
		
	}

}
