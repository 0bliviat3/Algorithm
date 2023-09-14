import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		HashSet<String> set = new HashSet<>();
		
		set.add("Never gonna give you up");
		set.add("Never gonna let you down");
		set.add("Never gonna run around and desert you");
		set.add("Never gonna make you cry");
		set.add("Never gonna say goodbye");
		set.add("Never gonna tell a lie and hurt you");
		set.add("Never gonna stop");
		
		boolean flag = false;
		while(n-- > 0) {
			if(!set.contains(in.readLine())) {
				flag = true;
			}
		}
		
		in.close();
		
		if(flag) {
			System.out.print("Yes");
		}else {
			System.out.print("No");
		}
	}

}
