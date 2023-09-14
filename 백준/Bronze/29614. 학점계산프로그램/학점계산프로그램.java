import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] S = in.readLine().toCharArray();
		
		in.close();
		
		HashMap<Character,Double> map = new HashMap<>();
		
		map.put('A', 4.0);
		map.put('B', 3.0);
		map.put('C', 2.0);
		map.put('D', 1.0);
		map.put('F', 0.0);
		
		
		int n = S.length;
		int mod = n;
		double sum = 0;
		for(int i = 0; i < n; i++) {
			if(S[i] == '+') {
				sum += 0.5;
				mod--;
			}else {
				sum += map.get(S[i]);
			}
		}
		
		System.out.printf("%.5f", sum/mod);
		
	}

}
