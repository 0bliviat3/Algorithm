import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		in.close();
		int cnt1 = 0;
		int cnt2 = 0;
		for(int i=1;i<=8;i++) {
			int n = Integer.parseInt(st.nextToken());			
			if(i == n) {
				cnt2++;
			}else {
				if(9-i == n) {
					cnt1++;
				}				
			}
		}
		if(cnt1 == 8) {
			sb.append("descending");
		}else if(cnt2 == 8) {
			sb.append("ascending");
		}else {
			sb.append("mixed");
		}
		System.out.print(sb);

	}

}