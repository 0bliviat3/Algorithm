import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static Integer[] dp;
	static int[] arr;
	
	static int getSum(int n) {
		if(dp[n] == null) {
			dp[n] = Math.max(getSum(n - 2) , getSum(n - 3) + arr[n - 1]) + arr[n];
		}
		return dp[n];
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		arr = new int[n + 1];
		dp = new Integer[n + 1];
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		in.close();
		dp[0] = arr[0];
		dp[1] = arr[1];
		
		if(n >= 2) {
			dp[2] = arr[1] + arr[2];
		}
		System.out.print(getSum(n));		
	}
}