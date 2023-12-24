import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.BiFunction;

public class Main {

	public static void main(String[] args) {
		new BOJ7511Sol().run();
	}

}

class BOJ7511Sol {
	
	private static final String CASE = "Scenario %d:\n";
	private static final char NEXT_LINE = '\n';
	private int[] parent;
	
	private void clear(int n) {
		parent = new int[n];
		for(int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}
	
	private int getParent(int x) {
		if(parent[x] == x) {
			return x;
		}
		return parent[x] = getParent(parent[x]);
	}
	
	private int union(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		if(a < b) {
			return parent[b] = a;
		}
		return parent[a] = b;
	}
	
	private int find(int a, int b) {
		if(getParent(a) == getParent(b)) {
			return 1;
		}
		return 0;
	}
	
	private void process() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();
		int testCase = Integer.parseInt(in.readLine());
		
		for(int i = 1; i <= testCase; i++) {
			ans.append(String.format(CASE, i));
			int n = Integer.parseInt(in.readLine());
			clear(n);
			int k = Integer.parseInt(in.readLine());
			while(k-- > 0) {
				setParam(in.readLine(), this::union);
			}
			int m = Integer.parseInt(in.readLine());
			while(m-- > 0) {
				ans.append(setParam(in.readLine(), this::find)).append(NEXT_LINE);
			}
			ans.append(NEXT_LINE);
		}
		System.out.print(ans);
	}
	
	private int setParam(String input ,BiFunction<Integer, Integer, Integer> func) {
		StringTokenizer st = new StringTokenizer(input, " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		return func.apply(a, b);
	}
	
	void run() {
		try {
			process();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
