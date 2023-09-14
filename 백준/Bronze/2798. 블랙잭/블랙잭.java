import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(in.readLine()," ");
		in.close();
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}	
		int max = 0;
		for(int i = 0; i < n - 2; i++) {
			int sum = arr[i];		
			for(int j = i + 1; j < n - 1; j++) {
				sum = arr[i] + arr[j];
				for(int k = j + 1; k < n; k++) {
					sum = arr[i] + arr[j] + arr[k];
					if(sum <= m) {
						if(max < sum) {
							max = sum;
						}
					}
				}
			}
		}
		System.out.print(max);
	}

}