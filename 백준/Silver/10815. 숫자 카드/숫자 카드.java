import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(in.readLine()); // 갖고있는 카드의 수
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int[] card = new int[n];
		
		for(int i = 0; i < n; i++) { // 갖고있는 카드 배열에 저장 -- N
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(card); // 정렬 NlogN
		
		int m = Integer.parseInt(in.readLine()); // 검사할 카드의 수
		
		st = new StringTokenizer(in.readLine()," ");
		
		in.close();
		
		// MlogM
		for(int i = 0; i < m; i++) { // 카드 검사 시작 -- M
			int now = Integer.parseInt(st.nextToken());
			int chk = Arrays.binarySearch(card, now); // 이진탐색 logM
			int no = (chk < 0) ? 0 : 1;
			out.write(no + " ");	
		}
		
		out.flush();
		out.close();
	}

}
