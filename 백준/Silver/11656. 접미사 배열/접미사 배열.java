import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	public static void main(String[] args) {
		BOJ11656Sol instance = new BOJ11656Sol();
		instance.run();
	}

}

class BOJ11656Sol {
	
	private ArrayList<String> post = new ArrayList<>();
	
	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		int len = s.length();
		setList(s, len);
	}
	
	private void setList(String s, int len) {
		for(int i = 0; i < len; i++) {
			post.add(s.substring(i));
		}
		Collections.sort(post);
	}
	
	private String build() {
		StringBuilder sb = new StringBuilder();
		for(String s : post) {
			sb.append(s).append('\n');
		}
		return sb.toString();
	}
	
	void run() {
		try {
			init();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			System.out.print(build());
		}
	}
	
}