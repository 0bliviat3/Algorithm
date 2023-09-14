import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(),": ");
		int s = Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());
		String chat = in.readLine();
		Set<String> name = new HashSet<>();
		int cnt = 0;
		while(chat != null && !chat.isEmpty()) {
			st = new StringTokenizer(chat,": ");
			int time = Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());
			String now = st.nextToken();
			
			if(time <= s) {
				name.add(now);
			}else if(e <= time && time <= q) {
				if(name.contains(now)) {
					cnt++;
					name.remove(now);
				}
			}
			chat = in.readLine();
		}
		
		in.close();
		
		System.out.print(cnt);
	}

}
