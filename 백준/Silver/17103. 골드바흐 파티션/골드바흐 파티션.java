import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static final int magicNumber = 1_000_000;
	static boolean[] prime = new boolean[magicNumber];
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		primeArr();
		
		StringBuilder sb = new StringBuilder();
		
		while(t-- > 0) {
			int now = Integer.parseInt(in.readLine());
			int cnt = 0;
			for(int i = 2; i <= now >> 1; i++) {
				if(!prime[i]) {
					if(!prime[now - i]) cnt++;
				}
			}
			sb.append(cnt + "\n");
		}
		in.close();
		
		System.out.print(sb);
	}
	
	static void primeArr() {
		prime[0] = true;
		prime[1] = true;
		for(int i = 2; i*i < magicNumber; i++) {
			for(int j = i*i; j < magicNumber; j += i) {
				prime[j] = true;
			}
		}
	}
}
