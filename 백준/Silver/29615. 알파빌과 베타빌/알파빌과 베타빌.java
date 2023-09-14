import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] order = new int[n + 1];
		
		st = new StringTokenizer(in.readLine()," ");
		for(int i = 0; i < n; i++) {
			order[Integer.parseInt(st.nextToken())] = i;
		}
		
		int cnt = m;
		st = new StringTokenizer(in.readLine()," ");
		for(int i = 0; i < m; i++) {
			if(order[Integer.parseInt(st.nextToken())] < m) {
				cnt--;
			}
		}
		
		in.close();
		
		System.out.print(cnt);
	}

}
