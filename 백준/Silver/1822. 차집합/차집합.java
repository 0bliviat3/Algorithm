import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int nA = Integer.parseInt(st.nextToken());
		int nB = Integer.parseInt(st.nextToken());
		Set<Integer> aSet = new TreeSet<>();
		st = new StringTokenizer(in.readLine()," ");
		while(nA-- > 0) {
			aSet.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(in.readLine()," ");
		in.close();
		
		while(nB-- > 0) {
			int now = Integer.parseInt(st.nextToken());
			if(aSet.contains(now)) aSet.remove(now);
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(aSet.size() + "\n");
		
		aSet.forEach(key ->{
			sb.append(key + " ");
		});
		
		System.out.print(sb);
	}

}