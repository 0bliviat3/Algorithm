import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] dpB, dpW;
	
	static void chk(int i, int j, int mod, char bw) {
		if(j%2 == mod) {
			if(bw == 'B') {
				dpW[i][j]++;
			}else {
				dpB[i][j]++;
			}
		}else {
			if(bw == 'B') {
				dpB[i][j]++;
			}else {
				dpW[i][j]++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		dpB = new int[n + 1][m + 1];
		dpW = new int[n + 1][m + 1];
		
		for(int i = 1; i <= n; i++) {
			String now = in.readLine();
			for(int j = 1; j <= m; j++) {
				dpB[i][j] = dpB[i - 1][j] + dpB[i][j - 1] - dpB[i - 1][j - 1];
				dpW[i][j] = dpW[i - 1][j] + dpW[i][j - 1] - dpW[i - 1][j - 1];
				char bw = now.charAt(j - 1);
				if(i%2 == 1) {
					chk(i,j,1,bw);
				}else {
					chk(i,j,0,bw);
				}
			}
		}
		
		in.close();
		
		int min = Integer.MAX_VALUE;
		
		for(int i = k; i <= n; i++) {
			for(int j = k; j <= m; j++) {
				int b = dpB[i][j] - dpB[i - k][j] - dpB[i][j - k] + dpB[i - k][j - k];
				int w = dpW[i][j] - dpW[i - k][j] - dpW[i][j - k] + dpW[i - k][j - k];
				b = Math.min(b, w);
				min = Math.min(b, min);
			}
		}
		
		System.out.print(min);
	}

}
