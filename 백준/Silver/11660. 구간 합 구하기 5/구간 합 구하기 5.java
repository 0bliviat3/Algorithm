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
		
		int[][] sumArr = new int[n + 1][n + 1];
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(in.readLine()," ");
			int sum = 0;
			for(int j = 1; j <= n; j++) {		
				sum += Integer.parseInt(st.nextToken());
				sumArr[i][j] = sum;
			}
		}
		int gap = 0;
		int[][] xy = new int[2][2];
		StringBuilder sb = new StringBuilder();
		while(m-- > 0) {
			st = new StringTokenizer(in.readLine()," ");
			xy[0][0] = Integer.parseInt(st.nextToken());
			xy[0][1] = Integer.parseInt(st.nextToken());
			xy[1][0] = Integer.parseInt(st.nextToken());
			xy[1][1] = Integer.parseInt(st.nextToken());
			for(int i = xy[0][0]; i <= xy[1][0]; i++) {
				gap += sumArr[i][xy[1][1]] - sumArr[i][xy[0][1] - 1];
			}
			sb.append(gap).append("\n");
			gap = 0;
		}
		in.close();
		System.out.print(sb);
	}

}
