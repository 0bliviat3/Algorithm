import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[][] metrix;
	static boolean[] visit;
	
	static int n,m,v;
	
	static int[] queue;
	static int front, rear;
	
	static StringBuilder sb = new StringBuilder();
	
	static void init(int a, int b) {
		metrix[a][b] = metrix[b][a] = true;
	}
	
	static void dfs(int node) {
		if(visit[node]) return;
		visit[node] = true;
		sb.append(node).append(' ');
		for(int i = 1; i <= n; i++) {
			if(metrix[node][i]) {
				dfs(i);
			}
		}
	}
	
	static void bfs(int start) {
		sb.append('\n');
		visit = new boolean[n + 1];
		queue[front++] = start;
		visit[start] = true;
		while(queue[rear] != 0) {
			int node = queue[rear];
			queue[rear++] = 0;
			rear%=n;
			sb.append(node).append(' ');
			for(int i = 1; i <= n; i++) {
				if(metrix[node][i] && !visit[i]) {
					visit[i] = true;
					queue[front++] = i;
					front%=n;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		metrix = new boolean[n + 1][n + 1];
		visit = new boolean[n + 1];
		queue = new int[n];
		
		while(m-- > 0) {
			st = new StringTokenizer(in.readLine()," ");
			init(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		in.close();
		
		dfs(v);
		bfs(v);
		
		System.out.print(sb);
	}
	
}
