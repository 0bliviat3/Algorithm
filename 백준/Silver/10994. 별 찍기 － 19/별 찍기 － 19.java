import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static boolean[][] metrix;
	
	static void pattern(int n , int s, int e) {
		if(n == 0) return;
		
		for(int i = s; i < e; i++) {
			if(i == s || i == e - 1) {
				for(int j = s; j < e; j++) {
					metrix[i][j] = true;
				}				
			}else {
				metrix[i][s] = metrix[i][e - 1] = true;
			}
		}
		
		pattern(n - 1, s + 2, e - 2);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(in.readLine());
		
		in.close();
		
		int size = 1 + (n - 1 << 2);
		
		metrix = new boolean[size][size];
		
		pattern(n,0,size);
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(metrix[i][j]) {
					sb.append('*');
				}else {
					sb.append(' ');
				}
			}
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
	
}
