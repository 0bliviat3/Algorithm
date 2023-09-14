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
		int m = Integer.parseInt(st.nextToken());
		
		final int mod = 1_000_000_007;
		
		long temp1 = 1;
		long temp2 = 1;
		
		while(n-- > 0) {
			temp1*=m;
			temp2*=(m - 1);
			temp1%=mod;
			temp2%=mod;
		}
		
		long ans = (temp1 - temp2 + mod)%mod;
		
		System.out.print(ans);
	}

}
