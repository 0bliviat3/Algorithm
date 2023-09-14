import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		HashMap<String, Object> map = new HashMap<>();
		while (n-- > 0) {
			String group = in.readLine();
			int cnt = Integer.parseInt(in.readLine());
			String[] member = new String[cnt];
			for (int i = 0; i < cnt; i++) {
				String now = in.readLine();
				map.put(now, group);
				member[i] = now;
			}
			Arrays.sort(member);
			map.put(group, member);
		}

		while (m-- > 0) {
			String problem = in.readLine();
			String no = in.readLine();
			if (no.equals("0")) {
				String[] now = (String[]) map.get(problem);
				for (int i = 0; i < now.length; i++) {
					out.write(now[i] + "\n");
				}
			} else {
				out.write(map.get(problem) + "\n");
			}
		}

		in.close();

		out.flush();
		out.close();
	}

}
