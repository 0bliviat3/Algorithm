import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int k = Integer.parseInt(in.readLine());
		String[] letter = new String[k];
		String[] huffmanCode = new String[k];
		
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(in.readLine()," ");
			letter[i] = st.nextToken();
			huffmanCode[i] = st.nextToken();
		}
		
		String code = in.readLine();
		
		in.close();
		
		while(code.length() > 0) {
			int i = 0;
			while(!code.startsWith(huffmanCode[i])) {i++;}
			sb.append(letter[i]);
			code = code.substring(huffmanCode[i].length());
		}
		
		System.out.print(sb);
	}

}
