import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[5];
		int sum = 0;
		int idx = -1;
		for (int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		System.out.println(sb.append(sum / 5)); // average
		sb.setLength(0);
		for (int j = 0; j < 3; j++) {			
			int max = 0;
			for (int i = 0; i < arr.length; i++) {
				if (max < arr[i]) {
					max = arr[i];
					idx = i;
				}
			}
			if ((idx != -1) && (j != 2)) {
				arr[idx] = 0;
			}
		}
		System.out.println(arr[idx]);
	}

}