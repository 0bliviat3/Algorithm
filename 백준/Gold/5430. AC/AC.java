import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Deque<String> deque = new LinkedList<>();
		int t = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(t-- > 0) {
			/*
			 * 1. 수행할 함수
			 * 2. 배열에 들어갈 수의 개수
			 * 3. []의 형태로 배열에 들어있는 정수
			 */
			char[] functionArr = in.readLine().toCharArray();
			int arrLen = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine(),"[],");
			for(int i = 0; i < arrLen; i++) {
				deque.add(st.nextToken());
			}
			
			boolean reverse = false; // R함수 구분 false 일때 pollFirst
			int fLen = functionArr.length;
			boolean errorFlag = false;
			int dequeSize = deque.size();
			
			for(int i = 0; i < fLen; i++) {
				if(functionArr[i] == 'R') {
					reverse = !reverse;
				}else if(functionArr[i] == 'D') {
					if(reverse) { // pollLast
						if(deque.pollLast() == null) errorFlag = true;
					}else { // pollFirst
						if(deque.pollFirst() == null) errorFlag = true;
					}
					dequeSize--;
				}
			}
			
			// 여기부터는 출력
			if(errorFlag) { // 에러발생시
				sb.append("error\n");
			}else {
				sb.append("[");
				for(int i = 0; i < dequeSize; i++) {
					if(reverse) {
						sb.append(deque.pollLast());
					}else {
						sb.append(deque.pollFirst());
					}
					if(i != dequeSize - 1) {
						sb.append(",");
					}
				}
				sb.append("]\n");
			}
			
		}
		in.close();
		
		System.out.print(sb);
	}
}
