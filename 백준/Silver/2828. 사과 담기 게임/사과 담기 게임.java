import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int start = 1;
	static int end;
	static int cnt = 0;
	
	static void move(int t) {
		if(start <= t && end >= t) return;
		int gap = 0;
		if(t < start) {
			gap = start - t;
			cnt += gap;
			start -= gap;
			end -= gap;
		}else if(t > end) {
			gap = t - end;
			cnt += gap;	
			start += gap;
			end += gap;
		}
	}

	public static void main(String[] args)throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		int j = Integer.parseInt(in.readLine());
		
		while(j-- > 0) {
			int target = Integer.parseInt(in.readLine());
			move(target);
		}
		in.close();
		
		
		System.out.print(cnt);
	}
}
