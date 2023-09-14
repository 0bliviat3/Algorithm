import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[][] triangle = new int[n][n];
		int[][] dp = new int[n][n];
		
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine()," ");
			for(int j = 0; j <= i; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
			
			if(i == 0) {
				dp[0][0] = triangle[0][0];
			}else {
				for(int j = 0; j <= i; j++) {
					dp[i][j] = triangle[i][j];
					if(j == 0) {
						dp[i][j] += dp[i - 1][0];
					}else if(j == i) {
						dp[i][j] += dp[i - 1][j - 1];
					}else {
						dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
					}
				}				
			}
			
		}
		
		in.close();
		
		
		int max = 0;
		for(int i = 0; i < n; i++) {
			max = Math.max(max, dp[n - 1][i]);
		}
		
		System.out.println(max);
	}

}
