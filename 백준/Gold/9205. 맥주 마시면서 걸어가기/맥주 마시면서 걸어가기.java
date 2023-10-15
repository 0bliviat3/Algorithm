import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BOJ9205Sol instance = new BOJ9205Sol();
		System.out.print(instance.run());
		instance.close();
	}
}


class BOJ9205Sol {
	
	private int[][] nodeArr;
	private ArrayList<Integer>[] edges;
	private StringTokenizer st;
	
	@SuppressWarnings("unchecked")
	private void clear(int n) {
		nodeArr = new int[2][n + 2];
		edges = new ArrayList[n + 2];
		for(int i = 0; i < n + 2; i++) { edges[i] = new ArrayList<>(); }
	}
	
	String run() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(in.readLine());
		while(t-- > 0) {
			int n = Integer.parseInt(in.readLine());
			clear(n);
			for(int i = 0; i < n + 2; i++) { linkChk(i,in.readLine()); }
			
			if(bfs(n)) {
				sb.append("happy\n");
			}else {
				sb.append("sad\n");
			}
		}
		in.close();
		
		return sb.toString();
	}
	
	private void linkChk(int idx, String input) {
		st = new StringTokenizer(input," ");
		int x = nodeArr[0][idx] = Integer.parseInt(st.nextToken());
		int y = nodeArr[1][idx] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < idx; i++) {
			if(Math.abs(nodeArr[0][i] - x) + Math.abs(nodeArr[1][i] - y) <= 1000) {
				link(i,idx);
			}
		}
	}
	
	private void link(int a, int b) {
		edges[a].add(b);
		edges[b].add(a);
	}
	
	private boolean bfs(int n) {
		Integer[] queue = new Integer[n + 2];
		boolean[] visit = new boolean[n + 2];
		int front = 0;
		int rear = 0;
		queue[rear++] = 0;
		visit[0] = true;
		while(queue[front] != null) {
			int node = queue[front];
			if(node == n + 1) { return true; }
			queue[front++] = null;
			front %= n + 2;
			for(int edge : edges[node]) {
				if(!visit[edge]) {
					queue[rear++] = edge;
					visit[edge] = true;
					rear %= n + 2;
				}
			}
		}
		return false;
	}
	
	void close() {
		nodeArr = null;
		edges = null;
		st = null;
	}
	
}