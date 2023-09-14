import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		String n = st.nextToken();
		int b = Integer.parseInt(st.nextToken());
		int result = 0;
		int pow = n.length();
		for(int i=0;i<n.length();i++) {
			int now = n.charAt(i);
			if(now < 'A') { // number
				result += (now - '0')*(Math.pow(b, --pow));
			}else { // alpha
				result += (now - 'A' + 10)*(Math.pow(b, --pow));
			}
		}
		sb.append(result);
		System.out.print(sb);

	}

}