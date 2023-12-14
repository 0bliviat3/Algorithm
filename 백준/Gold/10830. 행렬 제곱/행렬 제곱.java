import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BOJ10830Sol instance = new BOJ10830Sol();
		instance.run();
	}

}

class BOJ10830Sol {
	
	private static final int MOD = 1000;
	private int[][] originMetrix;
	private int[][] ansMetrix;
	private int n;
	
	private int[][] multiple(int[][] metrixA, int[][] metrixB) {
		int[][] resultMetrix = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					resultMetrix[i][j] += metrixA[i][k] * metrixB[k][j];
					resultMetrix[i][j] %= MOD;
				}
			}
		}
		return resultMetrix;
	}
	
	private void square(long b) {
		while(b > 0) {
			if(b % 2 == 1) {
				ansMetrix = multiple(ansMetrix, originMetrix);
			}
			originMetrix = multiple(originMetrix, originMetrix);
			b /= 2;
		}
	}
	
	private void clear() {
		originMetrix = new int[n][n];
		ansMetrix = new int[n][n];
	}
	
	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		clear();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j = 0; j < n; j++) {
				originMetrix[i][j] = Integer.parseInt(st.nextToken());
			}
			ansMetrix[i][i] = 1; // unit metrix
		}
		
		square(b);
	}
	
	private void printAns() {
		StringBuilder ans = new StringBuilder();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				ans.append(ansMetrix[i][j]).append(' ');
			}
			ans.append('\n');
		}
		System.out.print(ans);
	}
	
	void run() {
		try {
			init();
		} catch (IOException e) {
			e.printStackTrace();
		}
		printAns();
	}
	
}