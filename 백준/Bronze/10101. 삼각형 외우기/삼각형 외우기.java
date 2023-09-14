import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		int cnt = 0;
		int[] arr = new int[3];
		for(int i=0;i<3;i++) {
			arr[i] = Integer.parseInt(in.readLine());
			if(arr[i] == 60) {
				cnt++;
			}
			sum+=arr[i];
		}
		String result = (sum == 180) ? null : "Error";
		if(cnt == 3) {
			result = "Equilateral";
		}
		if(arr[0] == arr[1] || arr[1] == arr[2] || arr[0] == arr[2]) {
			if(result == null) {
				result = "Isosceles";
			}
		}
		if(result == null) {
			result = "Scalene";
		}
		
		System.out.print(result);
	}
}