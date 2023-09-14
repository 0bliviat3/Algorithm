import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String word = in.readLine();
		
		in.close();
		
		Set<String> wordSet = new HashSet<>();
		
		for(int i = 0; i < word.length(); i++) {
			for(int j = i; j < word.length(); j++) {
				String now = word.substring(i,j + 1);
				wordSet.add(now);
			}
		}
		
		out.write(wordSet.size() + "");
		out.flush();
		out.close();
	}

}