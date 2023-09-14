import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(in.readLine());
		in.close();
		
		int top = 0;
		int next = 0;
		
		int[] queue = new int[n];
		for(int i = 1; i <= n; i++) {
			queue[i-1] = i;
		}
		
		int now = 1;
		
		while(true) {
			sb.append(queue[top] + " ");
			queue[top++] = 0;
			top%=n;
			if(top == next) {
				break;
			}
			now = queue[next++] = queue[top++];
			next%=n;
			top%=n;
		}
		System.out.print(sb);			
	}

}