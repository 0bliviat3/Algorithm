import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		in.close();
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		long big = (a>b) ? a : b;
		long small = (a>b) ? b : a;
		long temp = euclid(big,small);
		
		System.out.print(big/temp*small);
	}
	
	static long euclid(long big, long small) {
		if(big == small || big%small == 0) {
			return small;
		}
		long mod = big%small;
		return euclid(small, mod);
	}

}