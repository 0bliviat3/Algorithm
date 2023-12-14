import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BOJ36312Sol instance = new BOJ36312Sol();
		try {
			instance.run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class BOJ36312Sol {

	private static final int MOD = 1_000_000_007;

	private long getInverse(long b, int x) {
		if (x == 1) {
			return b;
		}
		long inverse = getInverse(b, x >> 1);
		inverse = inverse * inverse % MOD;
		if (x % 2 == 1) {
			inverse = inverse * b % MOD;
		}
		return inverse;
	}

	private long gcd(long a, long b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	private long getExpectedVal(String input) {
		StringTokenizer st = new StringTokenizer(input, " ");
		long n = Long.parseLong(st.nextToken());
		long s = Long.parseLong(st.nextToken());
		long gcd = gcd(n, s);

		n /= gcd;
		s /= gcd;

		return s * getInverse(n, MOD - 2) % MOD;
	}

	void run() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(in.readLine());

		long sum = 0;
		while (m-- > 0) {
			sum += getExpectedVal(in.readLine());
			sum %= MOD;
		}

		System.out.print(sum);
	}

}