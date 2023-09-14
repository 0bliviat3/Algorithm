import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		in.close();
		
		for(int i = 1; i <= n; i++) {
			if(n % i == 0) {
				if(--k == 0) {
					sb.append(i);
					break;
				}
			}
		}
		if(k != 0) {
			sb.append(0);
		}
		
		System.out.print(sb);
	}

}