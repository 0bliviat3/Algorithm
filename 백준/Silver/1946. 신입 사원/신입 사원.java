import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int getCnt(int n, int[] arr) {
		int cnt = n;
		int val = arr[1];
		for(int i = 2; i <= n; i++) {
			if(val < arr[i]) {
				cnt--;
			}else if(val > arr[i]) {
				val = arr[i];
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(in.readLine());
		StringTokenizer st;
		int[] arr;
		StringBuilder sb = new StringBuilder();
		while(testCase-- > 0) {
			int n = Integer.parseInt(in.readLine());
			arr = new int[n + 1];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine()," ");
				arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
			}
			sb.append(getCnt(n, arr) + "\n");
		}
		in.close();
		
		System.out.print(sb);
	}
}
