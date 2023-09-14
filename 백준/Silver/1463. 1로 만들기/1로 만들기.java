import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		in.close();
		int[] arr;
		if(n > 3) {
			arr = new int[n + 1];
		}else {
			arr = new int[4];
		}
		arr[2] = 1;
		arr[3] = 1;
		
		int temp = 0;
		
		for(int i = 4; i <= n; i++) {
			if(i%3 == 0) temp = arr[i/3] + 1;
			if(i%2 == 0) {
				if(temp == 0) {
					temp = arr[i/2] + 1;
				}else {
					temp = (temp < arr[i/2] + 1) ? temp : (arr[i/2] + 1);
				}
			}
			if(temp == 0) {
				temp = arr[i - 1] + 1;
			}else {
				temp = (temp < arr[i - 1] + 1) ? temp : (arr[i - 1] + 1);
			}
			arr[i] = temp;
			temp = 0;
		}
		
		System.out.print(arr[n]);
	}

}
