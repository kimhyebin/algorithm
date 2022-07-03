package level2;

public class coloringBook {

	static int areaNum;
	static int areaNumMaxRes;

	static int areaCnt = 0; // 영역 넓이 수

	static int checkNum;
	static int drc[][] = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } }; // 상하좌우

	public static void main(String[] args) {

		// input value
		int m = 6;
		int n = 4;
		int picture[][] = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 },
				{ 0, 0, 0, 3 } };

		// 초기화
		areaNum = 0;
		areaNumMaxRes = 0;

		int resArr[] = new int[2];

		resArr[0] = areaNum;
		resArr[1] = areaNumMaxRes;

		boolean visit[][] = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (picture[i][j] != 0 && !visit[i][j]) {
					areaNum++;
					dfs(picture, visit, i, j);
				}

				if (areaCnt > areaNumMaxRes)
					areaNumMaxRes = areaCnt;

				areaCnt = 0;
			}
		}

		resArr[0] = areaNum;
		resArr[1] = areaNumMaxRes;

		System.err.println(resArr[0] + " " + resArr[1]);
	}

	public static void dfs(int picture[][], boolean visit[][], int x, int y) {

		if (visit[x][y])
			return;

		visit[x][y] = true;

		areaCnt++;

		for (int i = 0; i < 4; i++) {
			int nx = x + drc[i][0];
			int ny = y + drc[i][1];

			if (nx < 0 || nx >= picture.length || ny < 0 || ny >= picture[0].length)
				continue;

			if (picture[x][y] == picture[nx][ny] && !visit[nx][ny]) {
				dfs(picture, visit, nx, ny);
			}
		}
	}
}