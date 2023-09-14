import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(in.readLine());
		
		while(t-- > 0) {
			
			int n = Integer.parseInt(in.readLine());
			if(n > 32) {
				sb.append(0).append('\n');
				in.readLine();
				continue;
			}
			
			String[] MBTI = in.readLine().split(" ");
			int min = Integer.MAX_VALUE;
			
			for(int i = 0; i < n; i++) {
				for(int j = i + 1; j < n; j++) {
					for(int k = j + 1; k < n; k++) {
						int temp = 0;
						
						for(int l = 0; l < 4; l++) {
							if(MBTI[i].charAt(l) != MBTI[j].charAt(l)) temp++;
							if(MBTI[i].charAt(l) != MBTI[k].charAt(l)) temp++;
							if(MBTI[j].charAt(l) != MBTI[k].charAt(l)) temp++;
						}
						
						min = Math.min(min, temp);
					}
				}
			}
			
			sb.append(min).append('\n');
			
		}
		
		in.close();
		
		System.out.print(sb);
	}

}
