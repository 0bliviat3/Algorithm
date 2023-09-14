import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int m = n - 1;
		int[] arr = new int[n];
		int[][] dp = new int[n][2];
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		in.close();
		
		for(int i = 0; i < n; i++) { // input
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n; i++) {
			dp[i][0] = 1;
			dp[m - i][1] = 1;
			for(int j = 0; j <= i; j++) {
				if(arr[j] < arr[i]) { // 증가하는 부분 수열
					dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
				}
				if(arr[m - j] < arr[m - i]) { // 역순으로 증가하는 부분 수열
					dp[m - i][1] = Math.max(dp[m - i][1], dp[m - j][1] + 1);
				}
			}
		}
		
		int max = 0;
		for(int i = 0; i < n; i++) {
			max = Math.max(max, dp[i][0] + dp[i][1] - 1);
		}
		
		System.out.print(max);
	}

}
