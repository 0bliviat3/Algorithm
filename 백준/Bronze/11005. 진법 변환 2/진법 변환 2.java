import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int remain = 0;
		char now = 0;
		while(n > 0) {
			remain = n%b;
			if(remain +'0' <= '9') {
				now = (char) (remain + '0');
			}else {
				now = (char) (remain -10 + 'A');
			}
			sb.append(now);
			n/=b;
		}
		sb.reverse();
		System.out.print(sb);

	}

}