import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[][] dp = new int[n][3];
		int[] grape = new int[n];
		int max = 0;
		
		grape[0] = Integer.parseInt(in.readLine());
		dp[0][0] = 0;
		dp[0][1] = grape[0];
		dp[0][2] = grape[0];
		
		for(int i = 1; i < n; i++) {
			grape[i] = Integer.parseInt(in.readLine());
			max = 0;
			for(int j = 0; j < 3; j++) {
				if(max < dp[i - 1][j]) {
					max = dp[i - 1][j];
				}
			}
			dp[i][0] = max;
			dp[i][1] = dp[i - 1][0] + grape[i];
			dp[i][2] = dp[i - 1][1] + grape[i];
		}
		
		in.close();
		
		max = 0;
		for(int i = 0; i < 3; i++) {
			if(max < dp[n - 1][i]) {
				max = dp[n - 1][i];
			}
		}
		
		System.out.print(max);
	}

}
