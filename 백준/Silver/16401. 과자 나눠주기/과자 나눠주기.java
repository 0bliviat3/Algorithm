import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] snack;

	static int binarySearch(int m, int end) {
		int start = 1;
		int mid = 0;
		while (start <= end) {
			mid = (start + end) / 2;
			if (cntFlag(m, mid)) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return end;
	}

	static boolean cntFlag(int m, int mid) {
		int modCnt = 0;
		for (int i = 0; i < snack.length; i++) {
			modCnt += snack[i] / mid;
		}
		return modCnt >= m;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		snack = new int[n];
		st = new StringTokenizer(in.readLine(), " ");
		int max = 0;

		for (int i = 0; i < n; i++) {
			snack[i] = Integer.parseInt(st.nextToken());
			if (max < snack[i])
				max = snack[i];
		}

		in.close();

		int ans = binarySearch(m, max);

		System.out.print(ans);
	}
}
