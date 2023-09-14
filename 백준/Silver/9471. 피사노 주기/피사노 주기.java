import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int p = Integer.parseInt(in.readLine());
		
		while(p-- >0) {
			st = new StringTokenizer(in.readLine()," ");
			sb.append(st.nextToken());
			sb.append(" ");
			int m = Integer.parseInt(st.nextToken());
			int a = 1;
			int b = 1;
			int cnt = 0;
			while ((a != 1 || b != 1) || cnt == 0) {
				int temp = a;
				a = b;
				b = (temp + b) % m;
				cnt++;
			}
			sb.append(cnt+"\n");
		}
		
		System.out.print(sb);
	}
}