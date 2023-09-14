import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int x = Integer.parseInt(in.readLine());
		in.close();
		int[] p = {1,1};
		boolean target = true;
		while(--x > 0) {			
			if(p[0] == 1 && p[1] == 1) {
				p[1]++;
				target = false;
			}else {
				int idx = (target) ? 0 : 1;
				int idx2 = (target) ? 1 : 0;
				if(p[idx] > 1) {
					p[idx2]++;
					p[idx]--;
					if(p[idx] == 1 && x > 1) {
						x--;
						p[idx2]++;
						target = !target;
					}
				}
			}
		}
		sb.append(p[0]);
		sb.append("/");
		sb.append(p[1]);
		
		System.out.print(sb);

	}

}