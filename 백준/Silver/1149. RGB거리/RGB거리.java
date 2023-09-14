import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[][] dp = new int[n + 1][3];
		int[][] rgb = new int[n][3];
		
		StringTokenizer st;
		for(int i = 0; i < n; i++) { // 입력받으면서 계산이 가능한가 생각해볼것
			st = new StringTokenizer(in.readLine()," ");
			for(int j = 0; j < 3; j++) {
				rgb[i][j] = Integer.parseInt(st.nextToken());
			}
			for(int j = 0; j < 3; j++) {
				dp[i + 1][j] = rgb[i][j] + Math.min(dp[i][(j + 1)%3], dp[i][(j + 2)%3]);				
			}
		}
		
		in.close();
		
		int ans = dp[n][0];
		for(int i = 1; i < 3; i++) {
			ans = Math.min(ans, dp[n][i]);
		}
		
		System.out.print(ans);
	}

}
