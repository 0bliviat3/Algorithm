import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<String,Integer> word = new HashMap<>();
		
		while(n-- > 0) {
			String now = in.readLine();
			if(now.length() >= m) {
				word.put(now, word.getOrDefault(now, 1) + 1);				
			}
		}
		
		in.close();		
		
		List<String> wordlist = new ArrayList<>(word.keySet());
				
		Collections.sort(wordlist, (String w1, String w2) -> {
			if(word.get(w1) != word.get(w2)) {
				return word.get(w2) - word.get(w1);
			}else if(w1.length() != w2.length()) {
				return w2.length() - w1.length();
			}else {
				return w1.compareTo(w2);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < wordlist.size(); i++) {
			sb.append(wordlist.get(i) + "\n");
		}
		
		System.out.print(sb);
	}

}

