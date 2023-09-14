import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StackImpl<Integer> stack = new StackImpl<>();
		
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(in.readLine());
		
		while(n-- > 0) {
			
			st = new StringTokenizer(in.readLine()," ");
			String order = st.nextToken();
			
			switch (order) {
			case "1":
				stack.push(Integer.parseInt(st.nextToken()));
				break;
			case "2":
				if(stack.empty()) {
					sb.append("-1\n");
				}else {
					sb.append(stack.pop()).append('\n');
				}
				break;
			case "3":
				sb.append(stack.size()).append('\n');
				break;
			case "4":
				if(stack.empty()) {
					sb.append("1\n");
				}else {
					sb.append("0\n");
				}
				break;
			case "5":
				if(stack.empty()) {
					sb.append("-1\n");
				}else {
					sb.append(stack.top()).append('\n');
				}
				break;
			default:
				break;
			}
		}
		
		in.close();
		
		System.out.print(sb);
	}

}



class StackImpl <T>{
	
	private int top = -1;
	private int size = 10;
	private T[] stack;
	
	@SuppressWarnings("unchecked")
	public StackImpl() {
		stack = (T[]) new Object[size];
	}
	
	public T top() {
		if(top == -1) return null;
		return stack[top];
	}
	
	public boolean empty() {
		if(top() == null) return true;
		return false;
	}
	
	public int size() {
		return top + 1;
	}
	
	public T pop() {
		if(!empty()) {
			return stack[top--];
		}
		return null;
	}
	
	public void push(T insert) {
		if(size() == size) {
			cloneStack();
		}
		stack[++top] = insert;
	}
	
	@SuppressWarnings("unchecked")
	private void cloneStack() {
		T[] temp = (T[]) new Object[size << 1];
		for(int i = 0; i < size; i++) {
			temp[i] = stack[i];
		}
		stack = temp;
		size*=2;
	}
	

}

