import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		String[] arr = input.split(" ");
		int n = Integer.parseInt(arr[0]);
		int k = Integer.parseInt(arr[1]);
		input = br.readLine();
		arr = input.split(" ");
		int idx = -1;
		for(int j=0;j<k;j++) {
			int max = -1;
			for(int i=0;i<n;i++) {
				int now = Integer.parseInt(arr[i]);
				if(max < now) {
					max = now;
					idx = i;
				}
			}
			if((idx != -1)&&(j != k-1)) {
				arr[idx] = "0";
			}			
		}
		System.out.println(sb.append(arr[idx]));
	}

}