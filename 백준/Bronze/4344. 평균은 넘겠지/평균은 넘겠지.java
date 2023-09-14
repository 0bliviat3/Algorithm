import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int c = Integer.parseInt(in.readLine());
		StringTokenizer st;
		while(c-- > 0) {
			st = new StringTokenizer(in.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			double sum = 0.0;
			
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
			}
			
			double avg = sum/n;
			double cnt = 0.0;
			for(int i = 0; i < n; i++) {
				if(avg < arr[i]) {
					cnt++;
				}
			}
			
			double result = cnt/n*100.0;
			sb.append(String.format("%.3f", result) + "%\n");
			
		}
		
		System.out.print(sb);
	}
}
