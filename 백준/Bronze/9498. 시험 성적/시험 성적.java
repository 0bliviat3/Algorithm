import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int score = Integer.parseInt(br.readLine());
		if(score>89) {
			sb.append("A");
		}else if(score>79) {
			sb.append("B");
		}else if(score>69) {
			sb.append("C");
		}else if(score>59) {
			sb.append("D");
		}else {
			sb.append("F");
		}
		System.out.println(sb);
	}

}
