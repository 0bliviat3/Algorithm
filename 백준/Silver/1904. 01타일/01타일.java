import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] dp = new int[1_000_001];
	
	static void fibo() {
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i < 1_000_001; i++) {
			dp[i] = (dp[i - 1] % 15746 + dp[i - 2] % 15746) % 15746;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		fibo();
		int n = Integer.parseInt(in.readLine());
		
		in.close();
		
		System.out.print(dp[n]);
	}
}