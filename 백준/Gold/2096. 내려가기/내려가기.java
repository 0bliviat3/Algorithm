import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.IntBinaryOperator;

public class Main {

	public static void main(String[] args) {
		BOJ2096Sol instance = new BOJ2096Sol();
		instance.run();
	}

}

class BOJ2096Sol {
	
	private int[][] dp;
	private int[][] metrix;
	private int n;
	
	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		dp = new int[n + 1][3];
		metrix = new int[n + 1][3];
		for(int i = 0; i < n; i++) {
			init(in.readLine(), i);
		}
		for(int i = 0; i < 3; i++) {
			dp[0][i] = metrix[0][i];
		}
	}
	
	private void init(String input, int i) {
		StringTokenizer st = new StringTokenizer(input, " ");
		for(int j = 0; j < 3; j++) {
			metrix[i][j] = Integer.parseInt(st.nextToken());
		}
	}
	
	private int calculate(IntBinaryOperator oper) {
		int l = 0;
		int r = 0;
		
		for(int i = 1; i <= n; i++) {
			l = oper.applyAsInt(dp[i - 1][0], dp[i - 1][1]);
			r = oper.applyAsInt(dp[i - 1][1], dp[i - 1][2]);
			
			dp[i][0] = l + metrix[i][0];
			dp[i][1] = oper.applyAsInt(r, l) + metrix[i][1];
			dp[i][2] = r + metrix[i][2];
		}
		
		return oper.applyAsInt(
				oper.applyAsInt(dp[n][0], dp[n][1]), dp[n][2]);
	}
	
	private void printAns() {
		System.out.print(
				calculate(Math::max) + " " + calculate(Math::min));
	}
	
	void run() {
		try {
			init();
			printAns();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
