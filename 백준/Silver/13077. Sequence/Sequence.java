import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int seq;
	
	static void sequence(int p, int q) {
		if(p == 1 && q == 1) return;
		if(p > q) {
			sequence(p - q,q);
			seq <<= 1;
			seq++;
		}else {
			sequence(p,q - p);
			seq <<= 1;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(in.readLine());
		
		while(t-- > 0) {
			seq = 1;
			st = new StringTokenizer(in.readLine(),"/");
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			sequence(p,q);
			sb.append(seq).append('\n');
		}
		
		in.close();
		
		System.out.print(sb);
	}
	

}


