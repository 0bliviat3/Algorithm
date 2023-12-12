import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		BOJ1918Sol instance = new BOJ1918Sol();
		instance.run();
	}

}

enum OperatorConst {

	PLUS('+', 2),
	MINUS('-', 2),
	MUL('*', 1),
	DIVIDE('/', 1),
	BRACKET_START('(', 0),
	BRACKET_END(')', 3);

	private char operator;
	private int priority;

	OperatorConst(char operator, int priority) {
		this.operator = operator;
		this.priority = priority;
	}

	public char getOperator() {
		return operator;
	}

	public int getPriority() {
		return priority;
	}

	public static OperatorConst toConstant(char operator) {
		for (OperatorConst constant : OperatorConst.values()) {
			if (constant.getOperator() == operator) {
				return constant;
			}
		}
		return null;
	}
}

class BOJ1918Sol {

	private Stack<OperatorConst> stack;
	private StringBuilder postFix;

	private void clear() {
		stack = new Stack<>();
		postFix = new StringBuilder();
	}

	private void judge(char value) {
		OperatorConst constant = OperatorConst.toConstant(value);
		if (constant == null) {
			postFix.append(value);
			return;
		}
		if (value == OperatorConst.BRACKET_END.getOperator()) {
			meetEndBracket();
			return;
		}
		judgeOperator(constant);
	}

	private void judgeOperator(OperatorConst constant) {
		if (stack.isEmpty()) {
			stack.push(constant);
			return;
		}
		int priorty = stack.peek().getPriority();
		if (priorty > constant.getPriority() || priorty == 0) {
			stack.add(constant);
			return;
		}
		postFix.append(stack.pop().getOperator());
		judgeOperator(constant);
	}

	private void meetEndBracket() {
		OperatorConst constant = null;
		while (!stack.isEmpty()) {
			if (OperatorConst.BRACKET_START == (constant = stack.pop())) {
				break;
			}
			postFix.append(constant.getOperator());
		}
	}

	private void popAll() {
		while (!stack.isEmpty()) {
			postFix.append(stack.pop().getOperator());
		}
	}

	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] middleFix = in.readLine().toCharArray();
		clear();
		for (char value : middleFix) {
			judge(value);
		}
		popAll();
	}

	void run() {
		try {
			init();
			System.out.print(postFix);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
