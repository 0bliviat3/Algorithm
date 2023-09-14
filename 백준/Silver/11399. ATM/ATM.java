import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());

		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		in.close();

		int idx = 0;

		while (st.hasMoreTokens()) { // N
			arr[idx++] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr); // NlogN

		int sum = 0;
		int result = 0;

		for (int i = 0; i < n; i++) { // N
			sum += arr[i];
			result += sum;
		}

		System.out.print(result);
	}

}
