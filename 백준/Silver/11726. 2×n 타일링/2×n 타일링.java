import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] fiboArr = new int[1001];
	static final int mod = 10007;

	static int getFiboNum(int n) {
		if (fiboArr[n] != 0)
			return fiboArr[n];
		return fiboArr[n] = (getFiboNum(n - 1) + getFiboNum(n - 2)) % mod;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		fiboArr[1] = 1;
		fiboArr[2] = 2;
		System.out.print(getFiboNum(Integer.parseInt(in.readLine())));
		in.close();
	}

}
