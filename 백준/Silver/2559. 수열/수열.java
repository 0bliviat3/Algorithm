import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine()," ");
		in.close();
		
		int[] temp = new int[n];
		int sum = 0;
		int max = -10_000_000;
		int j = k;
		for(int i = 0; i < n; i++) {
			temp[i] = Integer.parseInt(st.nextToken());
			sum += temp[i];
			if(j > 0) {
				j--;
				max = sum;
			}else {
				sum -= temp[i - k];
				max = (max < sum) ? sum : max;
			}
		}
		
		System.out.print(max);
	}

}