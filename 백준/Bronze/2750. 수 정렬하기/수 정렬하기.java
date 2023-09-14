import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] asc = new int[n];
		for(int i=0;i<n;i++) {
			asc[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		for(int j=0;j<n;j++) {
			int idx = -1;
			int min = 1001;
			for(int i=0;i<asc.length;i++) {
				if(min>asc[i]) {
					min = asc[i];
					idx = i;
				}
			}
			System.out.println(sb.append(min));
			sb.setLength(0);
			if(idx != -1) {
				asc[idx] = 1001;
			}
		}
	}

}