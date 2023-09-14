import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		
		final int temp = 4000;
		
		int[] count = new int [temp*2 + 1];
		
		int sum = 0;
		
		int min = 4000;
		int max = -4000;
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(in.readLine());
			if(max < arr[i]) max = arr[i];
			if(min > arr[i]) min = arr[i];
			sum += arr[i];
			count[arr[i] + temp]++;
		}
		in.close();
		
		int modeMax = 0;
		for(int i = 0; i < temp*2 + 1; i++) {
			if(modeMax < count[i]) {
				modeMax = count[i];
			}
		}
		
		int mode = -1;
		int cnt = 0;
		for(int i = 0; i < temp*2 + 1; i++) {
			if(modeMax == count[i]) {
				mode = i - temp;
				cnt++;
				if(cnt == 2) {
					mode = i - temp;
					break;
				}
			}
		}
		
		Arrays.sort(arr);
		
		int mean = (int) Math.round(sum/(double) n);
		int center = arr[n/2];
		int bound = max - min;
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(mean + "\n");
		sb.append(center + "\n");
		sb.append(mode + "\n");
		sb.append(bound + "\n");
		
		System.out.print(sb);
		
	}

}
