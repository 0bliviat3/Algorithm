import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Main m = new Main();
		int t = Integer.parseInt(in.readLine());
		int[] arr = {25,10,5};
		while (t-- > 0) {
			int c = Integer.parseInt(in.readLine());
			for(int i = 0; i<arr.length; i++) {
				int change = m.change(c, arr[i]);
				c -= change * arr[i];
				sb.append(change + " ");
			}
			sb.append(c + "\n");
		}
		System.out.print(sb);

	}

	private int change(int temp, int remain) { // 원시타입이라 리턴값으로 전달해줘야 함.
		int change = 0;
		while (temp > 0) {
			change += temp / remain;
			temp /= remain;
		}
		return change;
	}

}