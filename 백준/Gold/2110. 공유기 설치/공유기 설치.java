import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] house;
	static int n,c;
	
	static boolean distance(int mid) {
		int cnt = 1;
		int idx = 0;
		for(int i = 1; i < n; i++) {
			if(mid <= house[i] - house[idx]) {
				cnt++;
				idx = i;
			}
		}
		return cnt >= c;
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		house = new int[n];
		for(int i = 0; i < n; i++) {
			house[i] = Integer.parseInt(in.readLine());
		}
		in.close();
		Arrays.sort(house);
		
		int start = 0;
		int end = 1_000_000_000;
		int ans = 0;
		while(start <= end) {
			int mid = (start + end) >> 1;
			if(distance(mid)) {
				start = mid + 1;
			}else {
				end = mid - 1;
			}
			ans = end;
		}
		
		System.out.print(ans);
	}

}
