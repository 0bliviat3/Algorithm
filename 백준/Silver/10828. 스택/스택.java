import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class myStack{
	
	private StringTokenizer st;
	private List<Integer> stack = new ArrayList<>();
	private int now = -2; // default
	
	public void getOrder(String order) {
		st = new StringTokenizer(order, " ");
		String keyWord = st.nextToken();
		switch (keyWord) {
		case "push":
			int x = Integer.parseInt(st.nextToken());
			push(x);
			break;
		case "pop":
			now = pop();
			break;
		case "size":
			now = size();
			break;
		case "empty":
			now = empty();
			break;
		case "top":
			now = top();
			break;
		default:
			break;
		}
	}
	
	public int getNow() {
		return this.now;
	}
	
	public void setNow(int now) {
		this.now = now;
	}

	private int top() {
		if(empty() == 0) {
			return stack.get(size()-1);
		}
		return -1;
		
	}

	private int empty() {
		if(stack.isEmpty()) {
			return 1;
		}
		return 0;
		
	}

	private int size() {
		return stack.size();	
	}

	private int pop() {
		if(empty() != 1) {
			int last = stack.get(size()-1);
			stack.remove(size()-1);
			return last;
		}
		return -1;	
	}

	private void push(int x) {
		stack.add(x);	
	}
	
	
}


public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		myStack stack = new myStack();
		int n = Integer.parseInt(in.readLine());
		while(n-- >0) {
			stack.getOrder(in.readLine());
			int now = stack.getNow();
			if(now != -2) {
				sb.append(now);
				sb.append("\n");
				stack.setNow(-2);
			}
		}
		System.out.print(sb);

	}

}