import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BOJ1717Sol instance = new BOJ1717Sol();
		instance.run();
	}

}

class BOJ1717Sol {
	
	private static final int UNION = 0;
	private static final String YES = "yes\n";
	private static final String NO = "no\n";
	private int[] numberSet;
	private StringBuilder ans;
	
	private void clear(int n) {
		ans = new StringBuilder();
		numberSet = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			numberSet[i] = i;
		}
	}
	
	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		clear(n);
		while(m-- > 0) {
			order(in.readLine());
		}
	}
	
	private void order(String order) {
		StringTokenizer st = new StringTokenizer(order, " ");
		int operator = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		if(operator == UNION) {
			union(a, b);
			return;
		}
		find(a, b);
	}
	
	private int getParent(int element) {
		if(numberSet[element] == element) {
			return element;
		}
		return numberSet[element] = getParent(numberSet[element]);
	}
	
	private void union(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		if(a < b) {
			numberSet[b] = a;
			return;
		}
		numberSet[a] = b;
	}
	
	private void find(int a, int b) {
		if(getParent(a) == getParent(b)) {
			ans.append(YES);
			return;
		}
		ans.append(NO);
	}
	
	void run() {
		try {
			init();
			System.out.print(ans);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
