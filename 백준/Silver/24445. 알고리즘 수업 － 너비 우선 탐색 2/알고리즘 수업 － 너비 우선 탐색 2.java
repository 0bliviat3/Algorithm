import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] edges;
	
	static int[] queue;
	
	static int[] visit;
	
	static int n,front,rear,cnt;
	
	@SuppressWarnings("unchecked")
	static void setting() {
		queue = new int[n];
		visit = new int[n + 1];
		edges = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) {
			edges[i] = new ArrayList<>();
		}
	}
	
	static void sorted() {
		for(int i = 1; i <= n; i++) {
			Collections.sort(edges[i], Collections.reverseOrder());
		}
	}
	
	static void init(int a, int b) {
		edges[a].add(b);
		edges[b].add(a);
	}
	
	static void bfs(int start) {
		queue[rear++] = start;
		visit[start] = ++cnt;
		while(queue[front] != 0) {
			int node = queue[front];
			queue[front++] = 0;
			front%=n;
			for(int i : edges[node]) {
				if(visit[i] == 0) {
					visit[i] = ++cnt;
					queue[rear++] = i;
					rear%=n;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		setting();
		
		while(m-- > 0) {
			st = new StringTokenizer(in.readLine()," ");
			init(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		in.close();
		
		sorted();
		
		bfs(start);
		
		for(int i = 1; i <= n; i++) {
			sb.append(visit[i]).append('\n');
		}
		
		System.out.print(sb);
	}

}
