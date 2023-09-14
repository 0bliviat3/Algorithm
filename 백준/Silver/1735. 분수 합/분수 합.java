import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] a = new int[2];
		int[] b = new int[2];
		for(int i = 0; i < 2; i++) {
			st = new StringTokenizer(in.readLine()," ");
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}
		in.close();
		int A = a[0]*b[1] + a[1]*b[0];
		int B = b[0]*b[1];
		int big = (A > B) ? A : B;
		int small = (A > B) ? B : A;
		
		int most = euclid(big,small);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(A/most + " ");
		sb.append(B/most);
		System.out.print(sb);
	}
	
	static int euclid(int b, int s) {
		if(b == s || b%s == 0) return s;
		return euclid(s, b%s);
	}

}
