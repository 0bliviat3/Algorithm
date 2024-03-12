import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractQueue;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        new BOJ11000Sol(new PriorityQueue<>(Course::compareTo)).run();
    }
}

class Course {
    int start;
    int end;

    Course(int start, int end) {
        this.start = start;
        this.end = end;
    }

    int compareTo(Course course) {
        if (this.start == course.start) {
            return this.end - course.end;
        }
        return this.start - course.start;
    }

    int compareEnd(Course course) {
        return this.end - course.end;
    }
}

class BOJ11000Sol {

    private final AbstractQueue<Course> heap;

    BOJ11000Sol(final AbstractQueue<Course> heap) {
        this.heap = heap;
    }

    private void init(String input) {
        StringTokenizer st = new StringTokenizer(input);
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        heap.add(new Course(start, end));
    }

    private int getRoom() {
        AbstractQueue<Course> rooms = new PriorityQueue<>(Course::compareEnd);
        while (!heap.isEmpty()) {
            Course course = heap.poll();
            if (rooms.isEmpty()) {
                rooms.add(course);
                continue;
            }

            if (rooms.peek().end <= course.start) {
                rooms.poll();
            }
            rooms.add(course);
        }
        return rooms.size();
    }

    private void solve() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        while(n-- > 0) {
            init(in.readLine());
        }
        System.out.print(getRoom());
    }

    void run() {
        try {
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

