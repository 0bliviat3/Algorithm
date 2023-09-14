import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		in.close();
		
		final int mod = 1_000_000_000;
		int[][] dp = new int[n][10];
		
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 10; j++) {
				if(i == 0) {
					if(j > 0) {
						dp[i][j] = 1;
					}
				}else {
					if(j == 0) {
						if(dp[i - 1][j] > 0) {
							dp[i][1] += dp[i - 1][j];
							dp[i][1]%=mod;
						}
					}else if(j == 9){
						dp[i][8] += dp[i - 1][j];
						dp[i][8]%=mod;
					}else {
						dp[i][j + 1] += dp[i - 1][j];
						dp[i][j - 1] += dp[i - 1][j];
						dp[i][j + 1]%=mod;
						dp[i][j - 1]%=mod;
					}
				}
			}
		}
		
		
		int sum = 0;
		for(int i = 0; i < 10; i++) {
			sum += dp[n - 1][i];
			sum%=mod;
		}

		System.out.print(sum);		
		
	}
 
}
