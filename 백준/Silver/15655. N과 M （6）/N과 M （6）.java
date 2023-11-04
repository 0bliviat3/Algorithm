import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BOJ15655Sol instance = new BOJ15655Sol();
		instance.run();
	}

}

class BOJ15655Sol {
	
	private final StringBuilder sb;
	private int[] numbers, val;
	private boolean[] visit;
	
	BOJ15655Sol() {
		sb = new StringBuilder();
	}
	
	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken()) + 1;
		numbers = new int[n];
		visit = new boolean[n];
		val = new int[m];
		st = new StringTokenizer(in.readLine()," ");
		for(int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numbers);
		dfs(1,m);
	}
	
	private void dfs(int n, int m) {
		if(n == m) {
			for(int i = 1; i < m; i++) {
				sb.append(val[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i = 0; i < numbers.length; i++) {
			if(!visit[i] && val[n - 1] < numbers[i]) {
				val[n] = numbers[i];
				visit[i] = true;
				dfs(n + 1, m);
				visit[i] = false;
			}
		}
	}
	
	void run() {
		try {
			init();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			System.out.print(sb);
		}
	}
	
}
