import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();
		
		while (true) {
			int n = Integer.parseInt(in.readLine());
			if (n == 0) {
				break;
			}
			String first = null;
			while (n-- > 0) {
				String line = in.readLine();
				if (first == null) {
					first = line;
				}
				boolean flag = first.compareToIgnoreCase(line) > 0;
				if (flag) {
					first = line;
				}
			}
			ans.append(first).append("\n");
		}
		
		
		System.out.print(ans);
		
	}

}
