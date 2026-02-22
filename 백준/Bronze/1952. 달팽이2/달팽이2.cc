#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>
#include <unordered_set>

void solve() {

	int m, n;
	std::cin >> m >> n;

	std::vector<std::vector<bool>> visited(m, std::vector<bool>(n, false));

	int cnt = 0;
	int x = 0, y = 0;
	int dx[] = { 0, 1, 0, -1 };
	int dy[] = { 1, 0, -1, 0 };

	for (int i = 0; i < m * n - 1; i++) {
		visited[x][y] = true;
		int nx = x + dx[cnt % 4], ny = y + dy[cnt % 4];
		if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny]) {
			cnt++;
			nx = x + dx[cnt % 4], ny = y + dy[cnt % 4];
		}

		x = nx;
		y = ny;
	}
	
	std::cout << cnt;

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}