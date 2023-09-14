import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(in.readLine());

		Set<String> member = new TreeSet<>(new Com());
		String[] chk;
		while (n-- > 0) { // insert >> NlogN
			chk = in.readLine().split(" ");
			
			if (chk[1].equals("leave")) {
				member.remove(chk[0]);				
			}else {
				member.add(chk[0]);				
			}
		}

		in.close();	
		
		member.forEach(now -> {
			sb.append(now + "\n");
		});


		System.out.print(sb);

	}

}

class Com implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		return o2.compareTo(o1);
	}
	
}
