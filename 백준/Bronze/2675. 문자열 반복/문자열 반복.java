import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(in.readLine());
		while(t-- >0) {
			st = new StringTokenizer(in.readLine()," ");
			int r = Integer.parseInt(st.nextToken());
			String word = st.nextToken();
			for(int i=0;i<word.length();i++) {
				int j = r;
				while(j-- >0) {
					sb.append(word.charAt(i));
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
		
	}

}