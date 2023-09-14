import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractSequentialList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	private AbstractSequentialList<Integer> myQueue = new LinkedList<>();
	private int idx = 0;
	
	public int getOrder(String order) {
		StringTokenizer st = new StringTokenizer(order," ");
		String temp = st.nextToken();
		int x = 0;
		if(st.hasMoreTokens()) x = Integer.parseInt(st.nextToken());
		switch (temp) {
		case "push":
			push(x);
			return -5;
		case "pop":
			return pop();
		case "size":
			return size();
		case "empty":
			return empty();
		case "front":
			return front();
		case "back":
			return back();
		default:
			return -5;
		}
	}
	
	private int empty() {
		if(myQueue.isEmpty()) {
			return 1;
		}
		return 0;
	}
	private void push(int x) {
		myQueue.add(x);
		idx++;
		
	}
	private int pop() {
		if(myQueue.isEmpty()) {
			return -1;
		}
		int now = myQueue.get(0);
		myQueue.remove(0);
		idx--;
		return now;
	}
	
	private int size() {
		return idx;
	}
	
	private int front() {
		if(empty() == 1) {
			return -1;
		}
		return myQueue.get(0);
	}
	
	private int back() {
		if(empty() == 1) {
			return -1;
		}
		return myQueue.get(idx - 1);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(in.readLine());
		Main m = new Main();
		while(n-- > 0) {
			int now = m.getOrder(in.readLine());
			if(now != -5) {
				sb.append(now + "\n");
			}		
		}
		in.close();
		System.out.print(sb);
	}

}
