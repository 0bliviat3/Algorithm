import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int k = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> map = new HashMap<>();

		String[] sortedKey = new String[l];
		for (int i = 0; i < l; i++) {
			String key = in.readLine();
			map.put(key, i);
			sortedKey[i] = key;
		}
		in.close();

		for (int i = 0; i < l; i++) {
			if (map.get(sortedKey[i]) == i) {
				sb.append(sortedKey[i] + "\n");
				k--;
			}
			if (k == 0) break;
		}

		System.out.print(sb);
	}

}
