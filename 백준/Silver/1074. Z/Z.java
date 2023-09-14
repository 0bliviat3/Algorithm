import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		in.close();
		int n = Integer.parseInt(st.nextToken());
		long r = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());
		
		System.out.print(zSelect(n,r,c));
	}

	static long zSelect(int n, long r, long c) {
		if (n == 1) {
			int cnt = 0;
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					if ((r % 2 == i) && (c % 2 == j)) {
						return cnt;
					}
					cnt++;
				}
			}
		}
		int n2 = n;
		while (r < 1 << n) {
			n--;
		}
		while (c < 1 << n2) {
			n2--;
		}
		long temp1 = (1 << n);
		long temp2 = (1 << n2);
		if (n == n2) {
			if (n < 1) {
				return zSelect(1, r, c);
			} else {
				return temp1 * temp1 * 2 + temp2 * temp2 + zSelect(n, r - temp1, c - temp1);
			}
		} else if (n < n2) {
			if (n < 1) {
				return temp2 * temp2 + zSelect(n2, r, c - temp2);
			} else {
				return temp1 * temp1 * 2 + temp2 * temp2 + zSelect(n2, r - temp1, c - temp2);
			}
		} else {
			if (n2 < 1) {
				return temp1 * temp1 * 2 + zSelect(n, r - temp1, c);
			} else {
				return temp1 * temp1 * 2 + temp2 * temp2 + zSelect(n, r - temp1, c - temp2);
			}
		}
	}

}
