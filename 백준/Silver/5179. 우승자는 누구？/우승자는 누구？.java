import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ5179Sol(new StringBuilder()).run();
    }
}

class Problem {
    boolean isSolve;
    int cnt; // 시도 수

    int getPoint(int time) { // 맞았을 경우만 호출
        if (isSolve) { // 이미 풀었다면
            return 0;
        }
        isSolve = true;
        return time + cnt * 20;
    }
}

class Candidate implements Comparable<Candidate> {

    int no;
    int total;
    int cnt; // 푼문제 수
    Problem[] problems;

    Candidate(int m, int no) {
        problems = new Problem[m];
        for(int i = 0; i < m; i++) {
            problems[i] = new Problem();
        }
        this.no = no;
    }

    void mark(int m, int t, int j) {
        if (j == 0) {
            problems[m].cnt++;
            return;
        }
        if (!problems[m].isSolve) {
            cnt++;
        }
        total += problems[m].getPoint(t);
    }

    @Override
    public int compareTo(Candidate o) {
        if (this.cnt == o.cnt) {
            return this.total - o.total;
        }
        return o.cnt - this.cnt;

    }

}

class BOJ5179Sol {
    private Candidate[] candidates;
    private final StringBuilder ans;
    private final String DATA_SET = "Data Set %d:\n";

    BOJ5179Sol(final StringBuilder ans) {
        this.ans = ans;
    }

    private void clear(int m, int p) {
        candidates = new Candidate[p];
        for (int i = 0; i < p; i++) {
            candidates[i] = new Candidate(m, i + 1);
        }
    }

    private void mark(String input) {
        StringTokenizer st = new StringTokenizer(input);
        int p = Integer.parseInt(st.nextToken()) - 1;
        int m = st.nextToken().charAt(0) - 'A';
        int t = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(st.nextToken());

        candidates[p].mark(m, t, j);
    }

    private void setAns(int m) {
        Arrays.stream(candidates)
                .sorted(Candidate::compareTo)
                .forEach(v -> ans
                        .append(v.no)
                        .append(' ')
                        .append(v.cnt)
                        .append(' ')
                        .append(v.total)
                        .append('\n'));
    }

    private void solve() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(in.readLine());
        for (int i = 1; i <= tc; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            clear(m, p);
            while(n-- > 0) {
                mark(in.readLine());
            }
            ans.append(String.format(DATA_SET, i));
            setAns(m);
            ans.append('\n');
        }
        System.out.print(ans);
    }

    void run() {
        try {
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
