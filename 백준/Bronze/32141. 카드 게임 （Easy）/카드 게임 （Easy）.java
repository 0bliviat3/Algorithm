import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws Exception{
		int n, h;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		
		long sum = 0L;
		for (int i = 0; i < n; i++) {
			sum += Long.parseLong(st.nextToken());
			if (sum >= h) {
				System.out.print(i + 1);
				return;
			}
		}
		
		System.out.print(-1);
	}
}
