import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int gcd(int a, int b) {
		if(b == 0) return a;
		return gcd(b, a%b);
	}
	
	static int getYear(int m, int n, int a, int b) {
		if(a == b) return a;
		int max = (m*n)/gcd(m,n);
		int now = Math.min(a, b);
		while(now <= max) {
			if(a < b) {
				a+=m;
			}else {
				b+=n;
			}
			if(a == b) return a;
			now = Math.min(a, b);
		}
		return -1;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(in.readLine());
		
		int[] data = new int[4];
		
		while(t-- > 0) {
			st = new StringTokenizer(in.readLine()," ");
			for(int i = 0; i < 4; i++) {
				data[i] = Integer.parseInt(st.nextToken());
			}
			sb.append(getYear(data[0],data[1],data[2],data[3])).append('\n');
		}
		
		in.close();
		
		System.out.print(sb);
	}
	
}
