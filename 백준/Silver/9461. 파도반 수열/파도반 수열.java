import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static long[] p = new long[100];

	static long dp(int n) {
		if (p[n] == 0) {
			p[n] = dp(n - 1) + dp(n - 5);
		}
		return p[n];
	}

	static void init() {
		p[0] = 1;
		p[1] = 1;
		p[2] = 1;
		p[3] = 2;
		p[4] = 2;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		init();
		dp(99);
		int t = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			sb.append(p[Integer.parseInt(in.readLine()) - 1] + "\n");
		}
		System.out.print(sb);
		in.close();
	}

}
