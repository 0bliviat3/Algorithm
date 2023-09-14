import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		final int constant = 1000;
		boolean[] arr = new boolean[2*constant + 1];
		
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		in.close();
		
		while(n-- > 0) {
			arr[constant + Integer.parseInt(st.nextToken())] = true;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < 2*constant + 1; i++) {
			if(arr[i]) {
				sb.append(i - constant);
				sb.append(" ");
			}
		}
		
		System.out.print(sb);
		
	}

}