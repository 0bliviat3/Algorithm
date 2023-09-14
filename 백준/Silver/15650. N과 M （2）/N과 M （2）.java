import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int n;
	static int m;
	static StringBuilder sb = new StringBuilder();
	
	static void dfs(int idx, int node) {
		if(node == m) {
			for(int i = 0; i < m; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i = idx; i <= n; i++) {
			arr[node] = i;
			dfs(i + 1,node + 1);
		}
		return;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		dfs(1,0);
		
		System.out.print(sb);
	}
}
