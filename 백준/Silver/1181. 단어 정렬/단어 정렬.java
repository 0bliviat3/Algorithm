import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(in.readLine());
		
		Set<String> wordSet = new HashSet<>();
		while(n-- > 0) {
			wordSet.add(in.readLine());
		}
		in.close();
		
		List<String> word = new ArrayList<>(wordSet);
		
		Collections.sort(word, new MyCom());
		
		for(int i = 0; i < word.size(); i++) {
			out.write(word.get(i) + "\n");
		}
		
		out.flush();
		out.close();
		
	}
}

class MyCom implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		if(o1.length() == o2.length()) {
			return o1.compareTo(o2);
		}
		return o1.length() - o2.length();
	}
	
}
