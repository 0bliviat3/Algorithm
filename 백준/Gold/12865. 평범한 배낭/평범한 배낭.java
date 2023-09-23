import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n,k;
	
	static int[][] things;
	
	static int[] dp;
	
	static void clear() {
		things = new int[2][n + 1];
		dp = new int[k + 1];
	}
	
	static int getCost() {
		for(int i = 1; i <= n; i++) {
			for(int j = k; j >= 1; j--) {
				if(j >= things[0][i]) {
					dp[j] = Math.max(dp[j], dp[j - things[0][i]] + things[1][i]);
				}
			}
		}
		return dp[k];
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		clear();
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(in.readLine()," ");
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			things[0][i] = w;
			things[1][i] = v;
		}
		
		in.close();
		
		System.out.print(getCost());
	}

}
