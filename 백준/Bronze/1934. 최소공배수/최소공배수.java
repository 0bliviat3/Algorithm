import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(t-- > 0) {
			st = new StringTokenizer(in.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int big = (a > b) ? a : b;
			int small = (a > b) ? b : a;
			int temp = euclid(big,small);
			sb.append(big/temp*small + "\n");
		}
		
		in.close();
		
		System.out.print(sb);
	}
	
	static int euclid(int big, int small) {
		if(big == small || big%small == 0) {
			return small;
		}
		int mod = big%small;
		return euclid(small, mod);
	}

}