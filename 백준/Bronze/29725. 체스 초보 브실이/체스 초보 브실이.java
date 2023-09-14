import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Character,Integer> map = new HashMap<>();
		
		map.put('.', 0);
		map.put('k', 0);
		map.put('K', 0);
		map.put('p', -1);
		map.put('P', 1);
		map.put('n', -3);
		map.put('N', 3);
		map.put('b', -3);
		map.put('B', 3);
		map.put('R', 5);
		map.put('r', -5);
		map.put('Q', 9);
		map.put('q', -9);
		
		int score = 0;
		
		for(int i = 0; i < 8; i++) {
			String now = in.readLine();
			for(int j = 0; j < 8; j++) {
				score += map.get(now.charAt(j));
			}
		}
		
		in.close();
		
		System.out.print(score);
	}

}
