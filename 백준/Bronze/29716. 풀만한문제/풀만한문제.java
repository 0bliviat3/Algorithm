import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	
	static int getLen(char temp) {
		if(temp == ' ') return 1;
		if(temp < 'A') return 2;
		if(temp < 'a') return 4;
		return 2;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int j = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		
		while(n-- > 0) {
			char[] now = in.readLine().toCharArray();
			int len = 0;
			
			for(int i = 0; i < now.length; i++) {
				len += getLen(now[i]);
			}
			
			if(len <= j) cnt++;
			
		}
		
		in.close();
		
		System.out.print(cnt);
	}

}
