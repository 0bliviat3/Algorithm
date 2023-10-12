import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st1;
		StringTokenizer st2;
		int t = Integer.parseInt(in.readLine());
		
		while(t-- > 0) {
			int n = Integer.parseInt(in.readLine());
			int[][] dp = new int[2][n];
			
			st1 = new StringTokenizer(in.readLine()," ");
			st2 = new StringTokenizer(in.readLine()," ");
			
			for(int i = 0; i < n; i++) {
				dp[0][i] = Integer.parseInt(st1.nextToken());
				dp[1][i] = Integer.parseInt(st2.nextToken());
				
				if(i == 1) {
					dp[0][1] += dp[1][0];
					dp[1][1] += dp[0][0];
				}else if(i > 1) {
					dp[0][i] += Math.max(dp[1][i - 1], dp[1][i - 2]);
					dp[1][i] += Math.max(dp[0][i - 1], dp[0][i - 2]);
				}
			}
			
			sb.append(Math.max(dp[0][n - 1], dp[1][n - 1])).append('\n');
			
		}
		
		in.close();
		
		System.out.print(sb);
	}

}
