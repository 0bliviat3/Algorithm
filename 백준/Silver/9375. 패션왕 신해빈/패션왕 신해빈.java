import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(in.readLine());
		HashMap<String,Integer> map = new HashMap<>();
		while(t-- > 0) {
			int n = Integer.parseInt(in.readLine());
			String[] cloth;
			int mul = 1;
			while(n-- > 0) {
				cloth = in.readLine().split(" ");
				map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
			}
			for(int value : map.values()) {
				mul *= value + 1;
			}
			
			map.clear();
			sb.append(mul - 1 + "\n");
		}
		
		System.out.print(sb);
	}
	
}
