import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(n-- > 0) {
			
			long now = Long.parseLong(in.readLine());
			
			if(now > 2) {
				while(true) {
					double temp = Math.sqrt((double) now);
					boolean flag = true;
					for(long j = 2; j <= temp; j++) {
						if(now % j == 0) {
							now++;
							flag = false;
							break;
						}
					}
					if(flag) {
						break;
					}
				}	
			}else {
				now = 2;
			}
			
			sb.append(now + "\n");	
		}
		
		System.out.print(sb);
		
	}
}
