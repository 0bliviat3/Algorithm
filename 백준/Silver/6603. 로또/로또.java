import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {     
    }

    static class BOJ6603Sol {
        
        private List<String> list;
        private boolean[] visit;
        private final StringBuilder ans;

        BOJ6603Sol(final StringBuilder ans) {
            this.ans = ans;
        }

        void clear(String input) {

            StringTokenizer st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            visit = new boolean[n];         

            while (st.hasMoreTokens()) {
                list.add(st.nextToken());
            }
        }

        //현재 로또번호 생성
        void makeLotto() {
            for (int i = 0; i < list.size(); i++) {
                if (visit[i]) {
                    ans.append(list.get(i)).append(' ');
                }
            }
            ans.append('\n');
        }

        //로또 번호 조합
        void createNumber(int start, int cnt) {
            if (cnt == 6) {
                makeLotto();
                return;
            }

            for (int i = start; i < list.size(); i++) {
                if (visit[i]) {
                    continue;
                }
                visit[i] = true;
                createNumber(i, cnt + 1);
                visit[i] = false;
            }
        }
        
        void run() throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String input = null;

            while (!(input = in.readLine()).equals("0")) {
                clear(input);
                createNumber(0, 0);
                ans.append('\n');
            }

            System.out.print(ans.toString());
        }

    }

    static {
        try {
            new BOJ6603Sol(new StringBuilder()).run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
