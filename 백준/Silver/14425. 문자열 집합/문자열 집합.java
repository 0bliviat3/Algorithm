import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Set<String> word = new HashSet<>();
		
		while(n-- > 0) {
			word.add(in.readLine());
		}
		int cnt = 0;
		while(m-- > 0) {
			cnt += (word.contains(in.readLine())) ? 1 : 0;
		}
		
		System.out.print(cnt);
	}

}
