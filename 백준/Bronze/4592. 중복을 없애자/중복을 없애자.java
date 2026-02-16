import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();
		
		while (true) {
			
			String str = in.readLine();
			if (str.equals("0")) {
				break;
			}
			StringTokenizer st = new StringTokenizer(str, " ");
			st.nextToken();
			int pre = 0;
			while (st.hasMoreTokens()) {
				int now = Integer.parseInt(st.nextToken());
				if (now == pre) {
					continue;
				}
				pre = now;
				ans.append(now).append(" ");
			}
			ans.append("$\n");
			
		}
		
		
		System.out.print(ans);
		
	}

}
