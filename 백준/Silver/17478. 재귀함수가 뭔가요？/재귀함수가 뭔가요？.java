import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	static void ask(int start, int end) {
		addBar(start);
		sb.append(SolveMessage.QUIZ.getMessage());
		if(start == end) {
			addBar(start);
			sb.append(SolveMessage.REAL_ANSWER.getMessage());
			addBar(start);
			sb.append(SolveMessage.AND_REPEAT.getMessage());
			return;
		}
		addBar(start);
		sb.append(SolveMessage.FAKE_ANSWER_1.getMessage());
		addBar(start);
		sb.append(SolveMessage.FAKE_ANSWER_2.getMessage());
		addBar(start);
		sb.append(SolveMessage.FAKE_ANSWER_3.getMessage());
		ask(start + 1, end);
		addBar(start);
		sb.append(SolveMessage.AND_REPEAT.getMessage());
	}
	
	static void addBar(int start) {
		for(int i = 0; i < start; i++) {
			sb.append(SolveMessage.UNDER_BAR.getMessage());
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int end = Integer.parseInt(in.readLine());
		in.close();
		sb.append(SolveMessage.INITIATE.getMessage());
		ask(0,end);
		System.out.print(sb);
	}

}

enum SolveMessage {
	
	INITIATE("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n"),
	QUIZ("\"재귀함수가 뭔가요?\"\n"),
	FAKE_ANSWER_1("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n"),
	FAKE_ANSWER_2("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n"),
	FAKE_ANSWER_3("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n"),
	REAL_ANSWER("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n"),
	AND_REPEAT("라고 답변하였지.\n"),
	UNDER_BAR("____");
	
	private String message;
	
	SolveMessage(String message) {
		this.message = message;
	}
	
	String getMessage() { return message; }
	
}