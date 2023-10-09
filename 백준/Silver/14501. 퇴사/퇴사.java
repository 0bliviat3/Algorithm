import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(in.readLine());
		int[] dp = new int[n + 1];
		int[] t = new int[n];
		int[] p = new int[n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine()," ");
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		in.close();
		
		for(int i = 0; i < n; i++) {
			if(i + t[i] <= n) { dp[i + t[i]] = Math.max(dp[i + t[i]], p[i] + dp[i]); }
			dp[i + 1] = Math.max(dp[i + 1], dp[i]);
		}
		
		System.out.print(dp[n]);
	}
	
}
