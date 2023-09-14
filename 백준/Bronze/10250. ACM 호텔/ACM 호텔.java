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
			int h = Integer.parseInt(st.nextToken());
			st.nextToken();
			int n = Integer.parseInt(st.nextToken());
			
			int h1 = n%h;
			int mod = n/h;
			int w = ((n - mod*h) > 0) ? (mod + 1) : mod;
			if(h1 == 0) {
				sb.append(h);
			}else {
				sb.append(h1);				
			}
			if(w < 10) {
				sb.append(0);
				sb.append(w);
			}else {
				sb.append(w);
			}
			
			
			
			sb.append("\n");
			
			
		}
		in.close();
		
		System.out.print(sb);
	}

}