package level2;

import java.util.LinkedList;
import java.util.Queue;

public class gameMap {

	static int[][] move = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int countRes = 0;

	static boolean[][] visit;

	public static void main(String[] args) {

		int[][] maps = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
				{ 0, 0, 0, 0, 1 } };

		visit = new boolean[maps.length][maps[0].length];

		int res = bfs(maps, 0, 0, 0);

		System.err.print("res: " + res);

	}

	private static int bfs(int[][] maps, int x, int y, int count) {

		Queue<int[]> queue = new LinkedList<>();

		queue.offer(new int[] { x, y, 1 });
		visit[x][y] = true;

		while (!queue.isEmpty()) {

			int[] pollTemp = queue.poll();

			if (pollTemp[0] == (visit.length - 1) && pollTemp[1] == (visit[0].length - 1))
				return pollTemp[2];

			for (int i = 0; i < 4; i++) {
				int moveX = pollTemp[0] + move[i][0];
				int moveY = pollTemp[1] + move[i][1];

				if (moveX >= 0 && moveX < visit.length && moveY >= 0 && moveY < visit[0].length && !visit[moveX][moveY]
						&& maps[moveX][moveY] == 1) {
					int moveCnt = pollTemp[2] + 1;
					queue.offer(new int[] {moveX, moveY, moveCnt});
					visit[moveX][moveY] = true;
				}
			}
		}
		return -1;
	}
}
