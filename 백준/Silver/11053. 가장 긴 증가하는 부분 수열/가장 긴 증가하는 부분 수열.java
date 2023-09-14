import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] dp = new int[n];
		int[] numbers = new int[n];
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		in.close();
		int max = 0;
		for(int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
			for(int j = 0; j <= i; j++) {
				if(numbers[j] < numbers[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			if(max < dp[i]) {
				max = dp[i];
			}
		}
		
		System.out.print(max);
	}

}
