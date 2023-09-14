import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		in.readLine();
		
		Set<String> gomgom = new HashSet<>();
		int cnt = 0;
		
		while(n-- > 1) {
			String now = in.readLine();
			if(now.equals("ENTER")) {
				cnt+=gomgom.size();
				gomgom.clear();
			}else {
				gomgom.add(now);				
			}
		}
		cnt += gomgom.size();
		
		System.out.print(cnt);
	}

}
