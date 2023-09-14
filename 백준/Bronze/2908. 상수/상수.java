import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		in.close();
		String[] arr = new String[2];
		for (int j = 0; j < 2; j++) {
			arr[j] = st.nextToken();
			String temp = new String();
			for (int i = 2; i >= 0; i--) {
				temp += String.valueOf(arr[j].charAt(i));
			}
			arr[j] = temp;
		}
		int a = Integer.parseInt(arr[0]);
		int b = Integer.parseInt(arr[1]);
		if(a>b) {
			sb.append(a);
		}else {
			sb.append(b);
		}
		System.out.print(sb);
		

	}

}