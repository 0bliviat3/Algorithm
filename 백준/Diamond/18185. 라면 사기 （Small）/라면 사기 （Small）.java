import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n + 2];
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		in.close();
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		int temp1 = 0;
		int temp2 = 0;
		int gap = 0;
		for(int i = 0; i < n; i++) {
			if(arr[i + 1] > arr[i + 2]) {
				gap = arr[i + 1] - arr[i + 2];
				temp1 = (arr[i] > gap) ? gap : arr[i];
				arr[i] -= temp1;
				arr[i + 1] -= temp1;
				sum += 5*temp1;
				
				gap = (arr[i + 1] > arr[i + 2]) ? arr[i + 2] : arr[i + 1];
				temp2 = (arr[i] > gap) ? gap : arr[i];
				arr[i] -= temp2;
				arr[i + 1] -= temp2;
				arr[i + 2] -= temp2;
				sum += 7*temp2;
				
			}else {
				gap = (arr[i + 1] > arr[i + 2]) ? arr[i + 2] : arr[i + 1];
				temp2 = (arr[i] > gap) ? gap : arr[i];
				arr[i] -= temp2;
				arr[i + 1] -= temp2;
				arr[i + 2] -= temp2;
				sum += 7*temp2;
				
				temp1 = (arr[i] > arr[i + 1]) ? arr[i + 1] : arr[i];
				arr[i] -= temp1;
				arr[i + 1] -= temp1;
				sum += 5*temp1;
			}
			sum += 3*arr[i];
		}
		
		System.out.print(sum);
	}

}
