import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		Set<String> homoDance = new HashSet<>();
		homoDance.add("ChongChong");
		
		while(n-- > 0) {
			String[] duo = in.readLine().split(" ");
			if(homoDance.contains(duo[0]) || homoDance.contains(duo[1])) {
				homoDance.add(duo[0]);
				homoDance.add(duo[1]);
			}
		}
		in.close();
		System.out.print(homoDance.size());
	}
}