import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		br.readLine();
		String[] arr = br.readLine().split(" ");
		String v = br.readLine();
        br.close();
		int cnt = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i].equals(v)) {
				cnt++;
			}
		}
		sb.append(cnt);
		System.out.print(cnt);
	}

}