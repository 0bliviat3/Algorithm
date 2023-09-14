import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(in.readLine());
		while(n-- >0) {
			int cnt = 0;
			int score = 0;
			String ox = in.readLine();
			for(int i=0;i<ox.length();i++) {
				char now = ox.charAt(i);
				if(now == 'O') {
					cnt++;
					score+=cnt;
				}else {
					cnt = 0;
				}
			}
			sb.append(score+"\n");
		}
		System.out.print(sb);
	}

}