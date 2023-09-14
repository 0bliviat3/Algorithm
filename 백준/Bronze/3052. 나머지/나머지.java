import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Set<Integer> numSet = new HashSet<>();
		int n = 10;
		while(n-- >0) {
			int a = Integer.parseInt(br.readLine());
			numSet.add(a%42);
		}
		sb.append(numSet.size());
		System.out.print(sb);
	}

}