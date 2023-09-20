import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	
	static char[] commend = { 'D' , 'S' , 'L' , 'R' };
	static boolean[] visit;
	static Resister[] queue;
	static int front, rear;
	
	static void clear() {
		front = rear = 0;
		visit = new boolean[10000];
		queue = new Resister[10000];
	}
	
	static Resister getNext(Resister now, char commend) {
		int num = now.num;
		if(commend == 'D') {
			num = (num << 1)%10000;
		}else if(commend == 'S') {
			num--;
			if(num == -1) num = 9999;
		}else if(commend == 'L') {
			num = num/1000 + (num%1000)*10;
		}else {
			num = (num%10)*1000 + num/10;
		}
		return new Resister(num, now.commend + commend);
	}
	
	
	static String bfs(int a, int b) {
		queue[rear++] = new Resister(a, new String());
		visit[a] = true;
		while(queue[front] != null) {
			Resister now = queue[front];
			queue[front++] = null;
			front%=10000;
			for(int i = 0; i < 4; i++) {
				Resister next = getNext(now,commend[i]);
				if(next.num == b) return next.commend;
				if(!visit[next.num]) {
					queue[rear++] = next;
					visit[next.num] = true;
					rear%=10000;
				}
			}
		}
		return null;
	}
	


	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(in.readLine());
		
		while(t-- > 0) {
			st = new StringTokenizer(in.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			clear();
			sb.append(bfs(a,b)).append('\n');
		}
		
		in.close();
		
		System.out.print(sb);
	}
	
}

class Resister {
	int num;
	String commend;
	
	Resister(int num, String commend){
		this.num = num;
		this.commend = commend;
	}
}
