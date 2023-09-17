import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	private ArrayList<Integer>[] edges;
	private int[] visit;
	private int[] queue;
	
	private int front, rear, n;
	
	@SuppressWarnings("unchecked")
	public void setting(int n) {
		this.n = n;
		visit = new int[n + 1];
		queue = new int[n];
		edges = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) {
			edges[i] = new ArrayList<>();
		}
	}
	
	public void init(int a, int b) {
		edges[a].add(b);
		edges[b].add(a);
	}
	
	public void bfs() {
		queue[rear++] = 1;
		while(queue[front] != 0) {
			int node = queue[front];
			queue[front++] = 0;
			front%=n;
			for(int i : edges[node]) {
				if(visit[i] == 0) {
					visit[i] = node;
					queue[rear++] = i;
					rear%=n;
				}
			}
		}
	}
	
	public void prt() {
		StringBuilder sb = new StringBuilder();
		for(int i = 2; i <= n; i++) {
			sb.append(visit[i]).append('\n');
		}
		System.out.print(sb);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Main b = new Main();
		
		b.setting(Integer.parseInt(in.readLine()));
		
		String now = in.readLine();
		
		while(now != null && !now.isEmpty()) {
			st = new StringTokenizer(now," ");
			b.init(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			now = in.readLine();
		}
		
		in.close();
		
		b.bfs();
		
		b.prt();
	}

}
