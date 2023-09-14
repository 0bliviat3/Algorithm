import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private long bridge(int n, int m) {
		if(m == 0 || n == 0) return 1;
		
		int big = (n > m - n) ? n : m - n;
		int small = (n > m - n) ? m - n : n;
		
		long value = 1;
		
		for(int i = m; i > big; i--) {
			value*=i;
		}

		for(int i = 1; i <= small; i++) {
			value/=i;
		}
		
		return value;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Main b = new Main();
		while(t-- > 0) {
			st = new StringTokenizer(in.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			long now = b.bridge(n,m);
			
			sb.append(now + "\n");
		}
		
		System.out.print(sb);
	}
	
}
