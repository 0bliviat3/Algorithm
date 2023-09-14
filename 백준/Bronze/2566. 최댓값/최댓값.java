import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int max = 0;
		int maxRow = 1;
		int maxCol = 1;
		for (int i = 1; i < 10; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j < 10; j++) {
				int now = Integer.parseInt(st.nextToken());
				if(max < now) {
					max = now;
					maxRow = i;
					maxCol = j;
				}
			}
		}
		sb.append(max + "\n" + maxRow + " " + maxCol);
		System.out.print(sb);
	}

}