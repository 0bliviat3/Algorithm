import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int S = 0;
		int M = Integer.parseInt(in.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(M-- > 0) {
			st = new StringTokenizer(in.readLine()," ");
			String order = st.nextToken();
			int x = (st.hasMoreTokens()) ? Integer.parseInt(st.nextToken()) - 1 : -1;
			
			switch (order) {
			case "add":
				S = S | (1 << x);
				break;
			case "remove":
				S = S & ( ~ (1 << x));
				break;
			case "check":
				int chk = (S == (S|(1 << x))) ? 1 : 0;
				sb.append(chk + "\n");
				break;
			case "toggle":
				S = S ^ (1 << x);
				break;
			case "all":
				S = 1048575;
				break;
			case "empty":
				S = 0;
				break;
			default:
				break;
			}
		}
		in.close();
		
		System.out.print(sb);
	}

}
