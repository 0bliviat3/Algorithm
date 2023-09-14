import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] dpArr = new int[1001];
	static final int mod = 10007;

	static int getDP(int n) {
		if (dpArr[n] != 0)
			return dpArr[n];
		return dpArr[n] = (getDP(n - 1) + (getDP(n - 2) << 1)) % mod;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		dpArr[1] = 1;
		dpArr[2] = 3;
		System.out.print(getDP(Integer.parseInt(in.readLine())));
		in.close();
	}
}