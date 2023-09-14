import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private int[] arr = new int[21];

	Main() {
		arr[0] = 0;
		arr[1] = 1;
	}

	public int fibo(int n) {
		for (int i = 2; i <= n; i++) {
			arr[i] = ((arr[i - 1] + arr[i - 2]));
		}
		return arr[n];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Main f = new Main();
		int n = Integer.parseInt(in.readLine());
		sb.append(f.fibo(n));
		System.out.print(sb);

	}
}