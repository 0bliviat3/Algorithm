import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[][] paper;
	
	static int white = 0;
	static int blue = 0;
	
	static void count(int col, int row, int n) {
		if(n == 1) {
			if(paper[col][row]) {
				blue++;
			}else {
				white++;
			}
			return;
		}
		int cnt = 0;
		for(int i = col; i < n + col; i++) {
			for(int j = row; j < n + row; j++) {
				if(paper[i][j]) cnt++;
			}
		}
		if(cnt == n*n) {
			blue++;
			return;
		}else if(cnt == 0){
			white++;
			return;
		}else {
			int mod = n >> 1;
			count(col,row,mod); 
			count(col + mod,row + mod,mod); 
			count(col + mod,row,mod);
			count(col,row + mod,mod);
		}
		
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st;
		paper = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine()," ");
			for(int j = 0; j < n; j++) {
				paper[i][j] = (st.nextToken().equals("1")) ? true : false;
			}
		}
		in.close();
		count(0,0,n);
		StringBuilder sb = new StringBuilder();
		sb.append(white).append("\n").append(blue);
		System.out.print(sb);
	}

}
