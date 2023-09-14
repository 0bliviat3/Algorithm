import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int n,front,rear;
	
	static Boolean[] visit;
	static Node[] queue;
	static ArrayList<Integer>[] edges;
	
	@SuppressWarnings("unchecked")
	static void setting() { // 초기화
		front = rear = 0;
		edges = new ArrayList[n + 1];
		visit = new Boolean[n + 1];
		queue = new Node[n];
		for(int i = 1; i <= n; i++) {
			edges[i] = new ArrayList<>();
		}
	}
	
	static void init(int a, int b) {
		edges[a].add(b);
		edges[b].add(a);
	}
	
	static String bfs() {
		for(int j = 1; j <= n; j++) {
			if(visit[j] == null) {
				queue[rear++] = new Node(true, j);
				visit[j] = true;
				
				while(queue[front] != null) {
					Node edge = queue[front];
					queue[front++] = null;
					front%=n;
					for(int i : edges[edge.no]) {
						if(visit[i] == null) { // 방문하지 않은 정점의 경우
							queue[rear++] = new Node(!edge.v,i);
							rear%=n;
							visit[i] = !edge.v;
						}else {
							if(visit[i] == edge.v) return "NO\n";
						}
					}
				}
			}
		}
		
		return "YES\n";
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int k = Integer.parseInt(in.readLine());
		
		while(k-- > 0) {
			st = new StringTokenizer(in.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			setting();
			
			while(e-- > 0) {
				st = new StringTokenizer(in.readLine()," ");
				init(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			
			sb.append(bfs());
		}
		
		in.close();
		
		System.out.print(sb);
		
	}

}


class Node{
	boolean v;
	int no;
	Node(boolean v, int no){
		this.v = v;
		this.no = no;
	}
}
