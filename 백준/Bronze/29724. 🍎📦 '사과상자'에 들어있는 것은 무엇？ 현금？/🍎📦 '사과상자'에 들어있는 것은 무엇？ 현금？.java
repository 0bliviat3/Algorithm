import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	/*
	 * 배즙은 질량을 계산하기 위함
	 * 사과는 개당 4000
	 */
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n = Integer.parseInt(in.readLine());
		
		int[] box = new int[3];
		
		int wei = 0;
		int pri = 0;
		
		while(n-- > 0) {
			st = new StringTokenizer(in.readLine()," ");
			String now = st.nextToken();
			for(int i = 0; i < 3; i++) {
				box[i] = Integer.parseInt(st.nextToken());
			}
			
			if(now.equals("A")) {
				// apple
				int cnt = 1;
				for(int i = 0; i < 3; i++) {
					cnt *= box[i]/12;
				}
				pri += cnt;
				wei += 1000;
				wei += cnt*500;
			}else {
				wei += 120*50;
			}			
		}
		
		sb.append(wei).append('\n').append(pri*4000);
		
		System.out.print(sb);
	}

}
