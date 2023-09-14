import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static final int max = 123_456 << 1;
	static boolean[] prime = new boolean[max + 1];
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		primeArr();
		
		while(n != 0) {
			
			int cnt = 0;
			
			for(int i = n + 1; i <= n << 1; i++) {
				if(!prime[i]) cnt++;
			}
			
			sb.append(cnt + "\n");
			
			n = Integer.parseInt(in.readLine());	
			
		}
		
		System.out.print(sb);
		
	}
	
	static void primeArr() {
		prime[0] = true;
		prime[1] = true;
		for(int i = 2; i * i <= max; i++) {
			for(int j = i * i; j <= max; j += i) {
				prime[j] = true;
			}
		}
	}
}
