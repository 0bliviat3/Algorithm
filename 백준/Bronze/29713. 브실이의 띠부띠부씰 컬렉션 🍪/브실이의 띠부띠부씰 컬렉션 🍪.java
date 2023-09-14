import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] arr = new int[10];
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String val = in.readLine();
		
		in.close();
		
		for(int i = 0; i < n; i++) {
			init(val.charAt(i));
		}
		
		int cnt = 0;
		boolean flag = false;
		
		while(!flag) {
			for(int i = 0; i < 10; i++) {
				if(arr[i] == 0) {
					flag = true;
					break;
				}
				
				if(i < 8) {
					arr[i]--;
				}else {
					if(arr[i] < 2) {
						flag = true;
						break;
					}
					arr[i]-=2;
				}
			}
			if(!flag) cnt++;
		}
		
		System.out.print(cnt);
		
		
	}
	
	
	static void init(char temp) {
		if(temp == 'B') {
			arr[0]++;
		}else if(temp == 'N') {
			arr[1]++;
		}else if(temp == 'Z') {
			arr[2]++;
		}else if(temp == 'O') {
			arr[3]++;
		}else if(temp == 'S') {
			arr[4]++;
		}else if(temp == 'I') {
			arr[5]++;
		}else if(temp == 'L') {
			arr[6]++;
		}else if(temp == 'V') {
			arr[7]++;
		}else if(temp == 'E') {
			arr[8]++;
		}else if(temp == 'R') {
			arr[9]++;
		}
	}

}
