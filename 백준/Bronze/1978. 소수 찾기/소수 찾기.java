import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int cnt = 0;
		int n2 = n;
		while(n2-- > 0) {
			int m = Integer.parseInt(st.nextToken());
			if(m == 1) {
				cnt++;
			}
			for(int i=2;i<m;i++) {
				if(m % i == 0) {
					cnt++;
					break;
				}
			}
		}
		System.out.print(n-cnt);

	}

}