import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		int[] len = new int[3];
		len[0] = Integer.parseInt(st.nextToken());
		len[1] = Integer.parseInt(st.nextToken());
		len[2] = Integer.parseInt(st.nextToken());
		
		
		while(len[0] != 0) {
			int max = 0;
			int idx = 0;
			for(int i = 0; i < len.length; i++) {
				if(max < len[i]) {
					max = len[i];
					idx = i;
				}
			}
			int sum = 0;
			int heru = 0;
			for(int i = 0; i < len.length; i++) {
				int now = len[i]*len[i];
				if(idx == i) {
					heru = now;
				}else {
					sum+=now;
				}
			}
			if(sum == heru) {
				sb.append("right\n");
			}else {
				sb.append("wrong\n");
			}
			
			st = new StringTokenizer(in.readLine()," ");
			len[0] = Integer.parseInt(st.nextToken());
			len[1] = Integer.parseInt(st.nextToken());
			len[2] = Integer.parseInt(st.nextToken());
		}
		
		System.out.print(sb);

	}

}