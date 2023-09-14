import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static boolean[][] arr;
	
	static void pattern(int x, int y, int n, boolean flag) {		
		if(flag) {
			for(int i = x; i < x + n; i++) {
				for(int j = y; j < y + n; j++) {
					arr[i][j] = true;
				}
			}
			return;
		}
		if(n == 1) return;
		int now = n/3;
		int cnt = 0;
		for(int i = x; i < x + n; i += now) {
			for(int j = y; j < y + n; j += now) {
				cnt++;
				if(cnt == 5) {
					pattern(i,j,now,true);
				}else {
					pattern(i,j,now,false);
				}
			}
		}
	}
	
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(in.readLine());
		in.close();
		arr = new boolean[n][n];
		pattern(0,0,n,false);
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!arr[i][j]) {
					out.append('*');
				}else {
					out.append(' ');
				}
			}
			out.append('\n');
		}
		
		out.flush();
		out.close();
	}

}
