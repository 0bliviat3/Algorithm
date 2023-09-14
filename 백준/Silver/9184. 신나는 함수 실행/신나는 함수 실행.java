import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][][] abc = new int[21][21][21];
	
	static int w(int a, int b, int c) {
		for(int i = 0; i <= a; i++) {
			for(int j = 0; j <= b; j++) {
				for(int k = 0; k <= c; k++) {
					if(i == 0 || j == 0 || k == 0) {
						abc[i][j][k] = 1;
					}else if(i < j && j < k) {
						abc[i][j][k] = abc[i][j][k - 1] + abc[i][j - 1][k - 1] - abc[i][j - 1][k];
					}else {
						abc[i][j][k] = abc[i - 1][j][k] + abc[i - 1][j - 1][k] + abc[i - 1][j][k - 1] - abc[i - 1][j - 1][k - 1];
					}
				}
			}
		}
		return abc[a][b][c];
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		w(20,20,20);
		while(true) {
			st = new StringTokenizer(in.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == -1 && b == -1 && c == -1) {
				break;
			}
			
			sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ");
			if(a <= 0 || b <= 0 || c <= 0) {
				sb.append(1).append("\n");
			}else if(a > 20 || b > 20 || c > 20) {
				sb.append(abc[20][20][20]).append("\n");
			}else {
				sb.append(abc[a][b][c]).append("\n");
			}
		}
		System.out.print(sb);
	}

}