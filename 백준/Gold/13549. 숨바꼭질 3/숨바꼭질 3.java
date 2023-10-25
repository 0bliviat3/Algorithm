import java.awt.Point;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BOJ13549Sol instance = new BOJ13549Sol();
		instance.run();
	}

}

class BOJ13549Sol {
	
	private final boolean[] edges;
	private final int[] startEnd;
	private final Point[] queue;
	private final int SIZE = 100_001;
	private int front, rear;
	
	BOJ13549Sol() {
		edges = new boolean[SIZE];
		startEnd = new int[2];
		queue = new Point[SIZE];
	}
	
	private void init() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		startEnd[0] = Integer.parseInt(st.nextToken());
		startEnd[1] = Integer.parseInt(st.nextToken());
	}
	
	private int bfs() {
		queue[rear++] = new Point(startEnd[0], 0);
		edges[startEnd[0]] = true;
		while(queue[front] != null) {
			Point edge = queue[front];
			queue[front++] = null;
			front %= SIZE;
			if(edge.x == startEnd[1]) { return edge.y; }
			teleportation(edge.x, edge.y);
			move(edge);
		}
		return 0;
	}
	
	private void teleportation(int start, int time) {
		start <<= 1;
		if(start >= SIZE || edges[start]) { return; }
		edges[start] = true;
		queue[rear++] = new Point(start, time);
		rear %= SIZE;
		teleportation(start, time);
	}
	
	private void move(Point edge) {
		int forward = edge.x + 1;
		int back = edge.x - 1;
        if(back >= 0 && !edges[back]) {
			move(back, edge.y);
		}
		if(forward < SIZE && !edges[forward]) {
			move(forward, edge.y);
		}
	}
	
	private void move(int point, int time) {
		edges[point] = true;
		queue[rear++] = new Point(point, time + 1);
		rear %= SIZE;
	}
	
	void run() {
		try {
			init();
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.out.print(bfs());
	}
	
}