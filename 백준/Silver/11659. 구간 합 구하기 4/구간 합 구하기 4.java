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
		int[] sumArr = new int[n + 1];
		
		st = new StringTokenizer(in.readLine()," ");
		for(int i = 1; i <= n; i++) {
			sumArr[i] = sumArr[i - 1] + Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		while(m-- > 0) {
			st = new StringTokenizer(in.readLine()," ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			sb.append(sumArr[j] - sumArr[i - 1]).append("\n");
		}
		
		System.out.print(sb);
	}

}
