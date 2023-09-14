import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		in.close();
		
		int cnt = 0;
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for(int i = 1; i <= n; i++) {
			String now = Integer.toString(i);
			for(int j = 0; j < now.length(); j++) {
				int idx = now.charAt(j) - '0';
				if(idx == m) cnt++;
			}
		}

		System.out.print(cnt);
	}

}