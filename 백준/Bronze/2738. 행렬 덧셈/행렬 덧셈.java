import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Metrix{
	int[][] a;
}


public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Metrix[] tmp = {new Metrix() , new Metrix() };
		tmp[0].a = new int[n][m];
		tmp[1].a = new int[n][m];
		
		for(int k = 0; k < 2; k++) {
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(in.readLine()," ");
				for(int j=0;j<m;j++) {
					tmp[k].a[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				sb.append(tmp[0].a[i][j] + tmp[1].a[i][j]);
				sb.append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
		
		
	}

}