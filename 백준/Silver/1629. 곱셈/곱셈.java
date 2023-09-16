import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());
		
		in.close();

		long ans = 1;
		
		while(b > 0) {
			if(b % 2 == 1) {
				ans = (ans*a)%c;
			}
			a = ((a % c) * (a % c)) % c;
			b/=2;
		}
		
		System.out.print(ans);
		
	}

}
