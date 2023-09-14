import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(in.readLine());
		
		for(int i = 1; i <= t; i++) {
			int now = Integer.parseInt(in.readLine());
			
			sb.append("Case #").append(i).append(": ");
			
			if(now > 4500) {
				sb.append("Round 1\n");
			}else if(now > 1000) {
				sb.append("Round 2\n");
			}else if(now > 25) {
				sb.append("Round 3\n");
			}else {
				sb.append("World Finals\n");
			}
		}
		
		System.out.print(sb);
	}

}
