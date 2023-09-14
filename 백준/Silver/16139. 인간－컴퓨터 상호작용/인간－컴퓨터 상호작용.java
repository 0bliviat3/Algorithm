import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] S = in.readLine().toCharArray();
		int n = S.length;
		int[][] sumArr = new int[26][n + 1];
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j < 26; j++) { // copy ... 객체타입 배열을 만들어 clone method를 사용해 저장해도 시간복잡도는 동일함(clone 시간복잡도 : O(n))
				sumArr[j][i] = sumArr[j][i - 1];
			}
			sumArr[S[i - 1] - 'a'][i]++;
		}
		
		int q = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		String[] nowQ;
		int cnt = 0;
		while(q-- > 0) {
			nowQ = in.readLine().split(" ");
			cnt = sumArr[nowQ[0].charAt(0) - 'a'][Integer.parseInt(nowQ[2]) + 1] - sumArr[nowQ[0].charAt(0) - 'a'][Integer.parseInt(nowQ[1])];
			sb.append(cnt).append('\n');
		}
		in.close();
		System.out.print(sb);
	}

}
