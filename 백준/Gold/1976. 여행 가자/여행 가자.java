import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BOJ1976Sol instance = new BOJ1976Sol();
		instance.run();
	}

}

class BOJ1976Sol {

	private static final String NO = "NO";
	private static final String YES = "YES";
	private int[] manage;
	private int n;

	private void clear() {
		manage = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			manage[i] = i;
		}
	}

	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		int m = Integer.parseInt(in.readLine());

		clear();

		for (int row = 1; row <= n; row++) {
			init(row, in.readLine());
		}

		String ans = chkPlan(in.readLine(), m) ? YES : NO;
		System.out.print(ans);
	}

	private void init(int row, String input) {
		StringTokenizer st = new StringTokenizer(input, " ");
		for (int col = 1; col <= n; col++) {
			if (st.nextToken().equals("1")) {
				union(row, col);
			}
		}
	}

	private int getManage(int node) {
		if (manage[node] == node) {
			return node;
		}
		return manage[node] = getManage(manage[node]);
	}

	private void union(int a, int b) {
		a = getManage(a);
		b = getManage(b);
		if (a < b) {
			manage[b] = a;
			return;
		}
		manage[a] = b;
	}
	
	private boolean find(int a, int b) {
		if(getManage(a) == getManage(b)) {
			return true;
		}
		return false;
	}
	
	private boolean chkPlan(String input, int m) {
		StringTokenizer st = new StringTokenizer(input, " ");
		int a = Integer.parseInt(st.nextToken());
		for(int i = 1; i < m; i++) {
			int b = Integer.parseInt(st.nextToken());
			if(!find(a, b)) {
				return false;
			}
		}
		return true;
	}
	
	void run() {
		try {
			init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}