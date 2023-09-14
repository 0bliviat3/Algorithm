import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine()," ");
		
		int k = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		in.close();
		
		int start = (k - x >= a) ? k - x : a;
		int end = (k + x <= b) ? k + x : b;
		
		int ans = end - start + 1;
		
		if(ans < 1) {
			System.out.print("IMPOSSIBLE");
		}else {
			System.out.print(ans);
		}
	}

}
