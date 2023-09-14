import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractSequentialList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	private AbstractSequentialList<Integer> deque = new LinkedList<>();
	
	private int empty() {
		if(deque.isEmpty()) {
			return 1;
		}
		return 0;
	}
	
	private int size() {
		return deque.size();
	}
	
	private void push_front(int x) {
		deque.add(0, x);
	}
	
	private void push_back(int x) {
		deque.add(x);
	}
	
	private int pop_front() {
		if(deque.isEmpty()) {
			return -1;
		}
		int now = deque.get(0);
		deque.remove(0);
		return now;
	}
	
	private int pop_back() {
		if(deque.isEmpty()) {
			return -1;
		}
		int now = deque.get(size() - 1);
		deque.remove(size() - 1);
		return now;
	}
	
	private int front() {
		if(deque.isEmpty()) {
			return -1;
		}
		return deque.get(0);
	}
	
	private int back() {
		if(deque.isEmpty()) {
			return -1;
		}
		return deque.get(size() - 1);
	}
	
	public int getOrder(String order) {
		StringTokenizer st = new StringTokenizer(order," ");
		String temp = st.nextToken();
		int x = 0;
		if(st.hasMoreTokens()) x = Integer.parseInt(st.nextToken());
		
		switch (temp) {
		case "push_front":
			push_front(x);
			return -5;
		case "push_back":
			push_back(x);
			return -5;
		case "pop_front":
			return pop_front();
		case "pop_back":
			return pop_back();
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

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		Main m = new Main();
		StringBuilder sb = new StringBuilder();
		while(n-- > 0) {
			int now = m.getOrder(in.readLine());
			if(now != -5) {
				sb.append(now + "\n");
			}
		}
		System.out.print(sb);
	}

}
