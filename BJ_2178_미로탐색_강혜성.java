package Day_0803;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2178_미로탐색_강혜성 {

	private static int minimum = Integer.MAX_VALUE;
	private static Queue<Point> queue = new LinkedList<Point>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int[][] mazeMap = new int[N][M];
		boolean[][] visit = new boolean[N][M];
		for (boolean[] v : visit)
			Arrays.fill(v, false);

		for (int y = 0; y < N; ++y) {
			String line = br.readLine();
			for (int x = 0; x < M; ++x)
				mazeMap[y][x] = line.charAt(x) - '0';
		}

		queue.add(new Point(0, 0));
		FindRoute(mazeMap, visit, 2);

		System.out.println(mazeMap[N-1][M-1]);
	}

	public static void FindRoute(int[][] mazeMap, boolean[][] visit, int count) {

		int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };

		Queue<Point> queueTemp = new LinkedList<Point>();
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			visit[p.y][p.x] = true;
			
			if(p.y == mazeMap.length - 1 && p.x == mazeMap[p.y].length - 1)
				return;

			for (int index = 0; index < dx.length; ++index) {
				int cx = p.x + dx[index], cy = p.y + dy[index];
				if (cx >= 0 && cx < mazeMap[p.y].length && cy >= 0 && cy < mazeMap.length) {
					if (mazeMap[cy][cx] == 1 && !visit[cy][cx]) {
						mazeMap[cy][cx] = count;
						queueTemp.add(new Point(cx, cy));
					}
				}
			}
		}
		queue = queueTemp;
		FindRoute(mazeMap, visit, count + 1);

	}

//	public static void findRoute(int[][] mazeMap, boolean[][] visit, int x, int y, int count) {
//		
//		if ((x == (mazeMap[y].length - 1)) && (y == (mazeMap.length - 1))) {
//			minimum = Math.min(minimum, count);
//			return;
//		}
//		
//		int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
//		
//		// 방문한 길 재방문 금지
//		visit[y][x] = true;
//		for(int index = 0; index < dx.length; ++index) {
//			int cx = x + dx[index], cy = y + dy[index];
//			// 범위 탐색
//			if(cx >= 0 && cx < mazeMap[y].length && cy >= 0 && cy < mazeMap.length) {
//				
//				if(mazeMap[cy][cx] == 1 && !visit[cy][cx]) {
//					findRoute(mazeMap, visit, cx, cy, count + 1);
//				}
//			}
//		}
//		visit[y][x] = false;
//	} 시간 초과
}
