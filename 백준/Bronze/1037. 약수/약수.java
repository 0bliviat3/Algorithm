import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int max = 1;
		int min = 1_000_001;
		while(t-- > 0) {
			int now = Integer.parseInt(st.nextToken());
			if(max < now) max = now;
			if(min > now) min = now;
		}
		
		System.out.print(max*min);
	}
	
}
