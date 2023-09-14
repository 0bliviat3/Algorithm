import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		in.close();
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] joArr = new int[n];
		for(int i = 1; i <= n; i++) {
			joArr[i-1] = i;
		}
		
		int front = 0;
		int next = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for(int j = 0; j < n; j++) {
			for(int i = 0; i < k - 1; i++) {
				int temp = joArr[front++]; // pop
				joArr[next++] = temp; // push
				front%=n;
				next%=n;
			}
			// k번째 죽여야댐
			sb.append(joArr[front++]); // pop
			front%=n;
			
			if(j == n - 1) {
				sb.append(">");
			}else {
				sb.append(", ");
			}
		}
		
		System.out.print(sb);
	}

}