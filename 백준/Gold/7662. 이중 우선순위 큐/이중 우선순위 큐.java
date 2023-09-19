import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		TreeMap<Integer,Integer> map;
		String[] order;
		int t = Integer.parseInt(in.readLine());
		
		while(t-- > 0) {
			int k = Integer.parseInt(in.readLine());
			map = new TreeMap<>();
			while(k-- > 0) {
				order = in.readLine().split(" ");
				int num = Integer.parseInt(order[1]);
				if(order[0].equals("I")){
					map.put(num, map.getOrDefault(num, 0) + 1);
				}else {
					if(map.isEmpty()) continue;
					if(num > 0) {
						num = map.lastKey();
					}else {
						num = map.firstKey();
					}
					if(map.put(num, map.get(num) - 1) == 1) {
						map.remove(num);
					}
				}
			}
			if(map.isEmpty()) {
				sb.append("EMPTY");
			}else {
				sb.append(map.lastKey()).append(' ').append(map.firstKey());
			}
			sb.append('\n');
		}
		
		System.out.print(sb);
	}

}
