import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] basket = new int[n];
		for(int i=0;i<n;i++) {
			basket[i] = i+1;
		}
		while(m-- >0) {
			st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int temp = 0;
			while(i<j) {
				temp = basket[i-1];
				basket[i-1] = basket[j-1];
				basket[j-1] = temp;
				i++;
				j--;
			}
		}
		for(int i=0;i<n;i++) {
			sb.append(basket[i]);
			sb.append(" ");
		}
		System.out.print(sb);

	}

}