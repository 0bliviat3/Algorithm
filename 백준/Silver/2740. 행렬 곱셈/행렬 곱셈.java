import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m,k;
	static int[][] metrixA,metrixB;
	static StringBuilder sb = new StringBuilder();
	
	static void metMul(int a, int b) {
		if(a == n) return;
		if(b == k) {
			sb.append('\n');
			metMul(a + 1,0);
			return;
		}
		int sum = 0;
		for(int i = 0; i < m; i++) {
			sum += metrixA[a][i]*metrixB[i][b];
		}
		sb.append(sum).append(' ');
		metMul(a,b + 1);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		metrixA = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine()," ");
			for(int j = 0; j < m; j++) {
				metrixA[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(in.readLine()," ");
		
		st.nextToken();
		k = Integer.parseInt(st.nextToken());
		
		metrixB = new int[m][k];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine()," ");
			for(int j = 0; j < k; j++) {
				metrixB[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        
        in.close();
		
		metMul(0,0);
		
		System.out.print(sb);
		
	}
	

}
