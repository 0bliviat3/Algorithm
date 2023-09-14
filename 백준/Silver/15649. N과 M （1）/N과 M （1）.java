import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static boolean[] visit;
	static int n;
	static int m;
	static StringBuilder sb = new StringBuilder();
	
	static void dfs(int node) {
		if(node == m) {
			for(int i = 0; i < m; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 1; i <= n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[node] = i;
				dfs(node + 1);
				visit[i] = false;
			}
		}
		return;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		visit = new boolean[n + 1];
		arr = new int[m];
		dfs(0);
		
		System.out.print(sb);
	}
}
