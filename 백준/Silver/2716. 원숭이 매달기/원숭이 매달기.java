import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(in.readLine());
		
		while(t-- > 0) {
			char[] str = in.readLine().toCharArray();
			int depth = 0;
			int max = 0;
			for(char angle : str) {
				if(angle == '[') {
					depth++;
				}else {
					depth--;
				}
				max = Math.max(depth, max);
			}
			sb.append((int)Math.pow(2, max)).append('\n');
		}
		
		in.close();
		
		System.out.print(sb);
	}

}
