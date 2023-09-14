import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Set<String> noEarEye = new TreeSet<>();
		Set<String> noEar = new HashSet<>();
		
		while(n-- > 0) {
			noEar.add(in.readLine());
		}
		
		
		while(m-- > 0) {
			String now = in.readLine();
			if(noEar.contains(now)) noEarEye.add(now);
		}
		
		sb.append(noEarEye.size() + "\n");
		
		noEarEye.forEach(now -> {
			sb.append(now + "\n");
		});
		
		System.out.print(sb);
	}

}
