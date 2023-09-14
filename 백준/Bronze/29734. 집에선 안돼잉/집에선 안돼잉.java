import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		
		long home = Long.parseLong(st.nextToken());
		long dok = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(in.readLine()," ");
		
		int move = Integer.parseInt(st.nextToken());
		int sleep = Integer.parseInt(st.nextToken());
		
		in.close();
		
		long zip = home;
		long nozip = dok;
		
		// 집에서 공부하는 경우
		// 8시간 이하인경우 그대로
		if(home > 8) {
			
			zip += (home/8)*sleep;
			
			// 나눈 나머지가 0인 경우 잘 필요없음
			if(home%8 == 0) {
				zip -= sleep;
			}
		}
		
		// 독서실
		if(dok < 8) { // 8시간 이하인경우
			nozip += move;
		}else {
			
			nozip += (dok/8)*(move*2 + sleep);
			
			/*
			 * 1. 독서실 이동
			 * 2. 8시간
			 * 3. 집으로 돌아옴
			 * 4. 잠
			 * 5. 다시 이동
			 * 6. 남은 시간 공부
			 */
			
			
			// 나눈 나머지가 0인경우 집에가서 자는 시간 제외
			if(dok%8 == 0) {
				nozip -= move + sleep;
			}else { // 남은시간 있는 경우
				nozip += move;
			}
		}
		
		
		if(zip < nozip) {
			System.out.print("Zip\n" + zip);
		}else {
			System.out.print("Dok\n" + nozip);
		}
		
	}
	
}
