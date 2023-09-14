import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(in.readLine());
		while(t-- > 0) {
			int k = Integer.parseInt(in.readLine());
			int n = Integer.parseInt(in.readLine());
			sb.append(apt(k,n) + "\n");
		}
		in.close();
		System.out.print(sb);
	}
	
	static int apt(int k, int n) {
		if(k == 0) return n;
		if(n == 0) return 0;
		return apt(k,n-1) + apt(k-1, n);
	}

}