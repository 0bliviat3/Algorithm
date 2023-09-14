import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int wordCnt = 0;
		int cnt = Integer.parseInt(in.readLine());
		for(int i = 0;i<cnt;i++) { // 단어 입력받기 시작
			String word = in.readLine();
			boolean flag = false;
			for(int j=0;j<word.length()-1;j++) {
				int now = word.substring(j+1).indexOf(word.charAt(j));
				if (now != -1) { // 찾지못한경우는 제외
					if(now != 0) { // 찾았을경우, 연속해서 나온경우가 아닐때
						flag = true;
					}
					if(flag) {
						wordCnt++; // 그룹 단어가 아니므로 카운트
						break; // 현재 단어의 판단이 끝남
					}					
				}
			}
		}
		in.close();
		System.out.println(sb.append(cnt-wordCnt));
	}

}