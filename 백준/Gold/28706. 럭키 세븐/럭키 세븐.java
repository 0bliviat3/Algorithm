import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		boolean[] dp;
		String[] v;
		StringBuilder sb = new StringBuilder();
		while(t-- > 0) {
			dp = new boolean[7];
			dp[1] = true;
			int n = Integer.parseInt(in.readLine());
			while(n-- > 0) {
				v = in.readLine().split(" ");
				boolean[] now = new boolean[7];
				for(int i = 0; i < 7; i++) {
					if(dp[i]) {
						dp[i] = false;
						if(v[0].equals("+")) {
							now[(i + Integer.parseInt(v[1]))%7] = true;
						}else {
							now[(i * Integer.parseInt(v[1]))%7] = true;
						}
						if(v[2].equals("+")) {
							now[(i + Integer.parseInt(v[3]))%7] = true;
						}else {
							now[(i * Integer.parseInt(v[3]))%7] = true;
						}
					}
				}
				for(int i = 0; i < 7; i++) {
					if(now[i]) dp[i] = true;
				}
			}
			if(dp[0]) {
				sb.append("LUCKY\n");
			}else {
				sb.append("UNLUCKY\n");
			}
		}
		in.close();
		
		System.out.print(sb);
	}

}