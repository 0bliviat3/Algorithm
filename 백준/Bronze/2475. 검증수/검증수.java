import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = 5;
		int sum = 0;
		while(n-- >0) {
			int now = Integer.parseInt(st.nextToken());
			sum+=now*now;
		}
		sb.append(sum%10);
		System.out.print(sb);
	}

}