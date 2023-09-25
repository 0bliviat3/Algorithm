import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine()," ");
		
		in.close();
		
		long[] mod = new long[m];
		long sum = 0;
		for(int i = 0; i < n; i++) {
			sum += Long.parseLong(st.nextToken());
			int modIdx = (int) (sum%m);
			mod[modIdx]++;
		}
		
		long ans = mod[0];
		
		for(int i = 0; i < m; i++) {
			if(mod[i] > 1) {
				ans += mod[i] * (mod[i] - 1) >> 1;
			}
		}
		
		System.out.print(ans);
	}

}
