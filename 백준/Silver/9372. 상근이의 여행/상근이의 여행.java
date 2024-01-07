import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        new BOJ9372Sol2().run();
    }
    
}


class BOJ9372Sol2 {

    /*
     * n개의 정점을 모두 지날때 최소간선 수는 n - 1이다.
     */

    void run() {
        try {
            process();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void process() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int testCase = Integer.parseInt(in.readLine());
        while(testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            while(m-- > 0) {
                in.readLine();
            }
            ans.append(n - 1).append('\n');
        }
        System.out.print(ans);
    }
    
}

class BOJ9372Sol {

    /*
     * union-find
     * 연결되어 있는 상태라면 넘어감
     * 연결되어 있지 않다면 연결하고 카운트 ⬆️
     */

    private List<Integer> parent;
    private int cnt;

    private void clear(int n) {
        cnt = 0;
        parent = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            parent.add(i);
        }
    }

    public void run() {
        try {
            process();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int getParent(int x) {
        if(parent.get(x) == x) {
            return x;
        }
        parent.set(x, getParent(parent.get(x)));
        return parent.get(x);
    }

    private void union(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if(a != b) {
            parent.set(b, a);
        }
    }

    private boolean find(int a, int b) {
        return getParent(a) == getParent(b);
    }

    private void count(String input) {
        StringTokenizer st = new StringTokenizer(input, " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if(find(a, b)) {
            return;
        }
        union(a, b);
        cnt++;
    }

    private void process() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int testCase = Integer.parseInt(in.readLine());
        while(testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            clear(n);
            while(m-- > 0) {
                count(in.readLine());
            }
            ans.append(cnt).append('\n');
        }
        System.out.print(ans);
    }

}
