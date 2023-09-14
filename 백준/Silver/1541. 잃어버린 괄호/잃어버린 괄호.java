import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), "+-", true);
		in.close();

		int[] value = new int[26];
		int temp = 0;
		int idx = 0;
		int ans = 0;
		String operator = null;
		while (st.hasMoreTokens()) {
			temp = Integer.parseInt(st.nextToken());
			if (st.hasMoreTokens()) operator = st.nextToken();
			ans += temp;
			if (operator != null && operator.equals("-")) {
				value[idx++] = ans;
				ans = 0;
			}
		}

		value[idx] = ans;
		ans = value[0];
		for (int i = 1; i <= idx; i++) {
			ans -= value[i];
		}

		System.out.print(ans);
	}

}
