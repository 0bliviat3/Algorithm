import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		in.close();
		int[] dp = new int[n + 1];
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			int min = 4;
			for (int j = 1; j * j <= i; j++) {
				int now = dp[i - j * j];
				min = (min > now) ? now : min;
			}
			dp[i] = min + 1;
		}

		System.out.print(dp[n]);
	}

}