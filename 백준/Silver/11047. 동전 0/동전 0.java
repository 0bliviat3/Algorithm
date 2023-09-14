import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		int idx = 0;
		while (n-- > 0) {
			int now = Integer.parseInt(in.readLine());
			if (now <= k) {
				arr[idx++] = now;
			}
		}

		in.close();
		idx--;
		int cnt = 0;

		while (k > 0) {
			if (arr[idx] <= k) {
				int temp = k/arr[idx];
				k -= arr[idx]*temp;
				cnt+=temp;
			}else {
				idx--;
			}
		}

		System.out.print(cnt);
	}
}
