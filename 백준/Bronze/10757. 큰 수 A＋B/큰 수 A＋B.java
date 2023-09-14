import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		in.close();
		String A = st.nextToken();
		String B = st.nextToken();
		StringBuilder sb = new StringBuilder();
		
		int i = A.length()-1;
		int j = B.length()-1;
		
		int n = (i>j) ? i : j;
		int temp = 0;
		while(n-- > -1) {
			int sum = temp;
			if(i > -1) {
				sum += (A.charAt(i) - '0');				
			}
			if(j > -1) {
				sum += (B.charAt(j) - '0');				
			}
			temp = 0;
			if(sum >= 10) {
				sum -= 10;
				temp = 1;
				
			}
			sb.append(sum);
			i--;
			j--;
		}
		if(temp == 1) {
			sb.append(temp);
		}
		
		System.out.print(sb.reverse());
	}

}
