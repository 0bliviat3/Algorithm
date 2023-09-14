import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dp;
	static int n,m;
	static StringBuilder sb = new StringBuilder();
	
	static void dfs(int idx) {
		if(idx == m) {
			for(int i = 0; i < m; i++) {
				sb.append(dp[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		for(int i = 1; i <= n; i++) {
			dp[idx] = i;
			dfs(idx + 1);
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		in.close();
		
		dp = new int[m];
		dfs(0);
		
		System.out.print(sb);
	}
	

}
