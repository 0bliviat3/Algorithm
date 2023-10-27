import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		StringBuilder sb= new StringBuilder();
		int[] room = new int[Integer.parseInt(st.nextToken())];
		int m = Integer.parseInt(st.nextToken());
		while(m-- > 0) {
			st = new StringTokenizer(in.readLine()," ");
			int idx = Integer.parseInt(st.nextToken()) - 1;
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if(room[idx] > start) {
				sb.append("NO\n");
			}else {
				sb.append("YES\n");
				room[idx] = end;
			}
		}
		in.close();
		System.out.print(sb);
	}

}
