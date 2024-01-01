import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ4195Sol().run();
    }
}

class BOJ4195Sol {

    private List<Integer> parent;
    private Map<String, Integer> ids;
    private List<Integer> cnts;
    private int idx;

    private void clear() {
        idx = 0;
        if(parent == null) {
            parent = new ArrayList<>();
        }
        if(ids == null) {
            ids = new HashMap<>();
        }
        if(cnts == null) {
            cnts = new ArrayList<>();
        }
        parent.clear();
        ids.clear();
        cnts.clear();
    }

    private int getParent(int x) {
        if(parent.get(x) == x) {
            return x;
        }
        parent.set(x, getParent(parent.get(x)));
        return parent.get(x);
    }

    private int union(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if(a == b) {
            return cnts.get(a);
        }
        if(a < b) {
            parent.set(b, a);
            int sum = cnts.get(a) + cnts.get(b);
            cnts.set(a, sum);
            cnts.set(b, sum);
            return sum;
        }
        parent.set(a, b);
        int sum = cnts.get(a) + cnts.get(b);
        cnts.set(a, sum);
        cnts.set(b, sum);
        return sum;
    }

    private int union(String input) {
        StringTokenizer st = new StringTokenizer(input, " ");
        int a = getIdx(st.nextToken());
        int b = getIdx(st.nextToken());
        return union(a, b);
    }

    private int getIdx(String id) {
        if(ids.containsKey(id)) {
            return ids.get(id);
        }
        ids.put(id, idx);
        parent.add(idx);
        cnts.add(1);
        idx++;
        return ids.get(id);
    }

    private void init() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int testCase = Integer.parseInt(in.readLine());
        while(testCase-- > 0) {
            int f = Integer.parseInt(in.readLine());
            clear();
            while(f-- > 0) {
                ans.append(union(in.readLine())).append('\n');
            }
        }
        System.out.print(ans);
    }

    void run() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
