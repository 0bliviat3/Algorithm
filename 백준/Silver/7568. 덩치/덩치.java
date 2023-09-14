import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st;
		int[][] dArr = new int[n][2];
		int[] rank = new int[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine()," ");
			dArr[i][0] = Integer.parseInt(st.nextToken());
			dArr[i][1] = Integer.parseInt(st.nextToken());
			rank[i] = 1;
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(dArr[i][0] > dArr[j][0] && dArr[i][1] > dArr[j][1]) {
					rank[j]++;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			sb.append(rank[i] + " ");
		}
		
		System.out.print(sb);
		
	}

}


