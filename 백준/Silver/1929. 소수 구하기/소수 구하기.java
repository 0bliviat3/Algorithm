import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		in.close();

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[] prime = new int[n + 1];
		for (int i = 2; i <= n; i++) {
			prime[i] = i;
		}

		for (int i = 2; i * i < n; i++) {
			if (prime[i] != 0) {
				for (int j = i * i; j <= n; j += i) {
					prime[j] = 0;
				}
			}
		}
		
		for(int i = 2; i <= n; i++) {
			if(prime[i] != 0 && prime[i] >= m && prime[i] != 4) {
				out.write(i + "\n");
			}
		}
		
		out.flush();
		out.close();
	}

}