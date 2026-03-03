#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>
#include <unordered_map>

void solve() {

	int n, m;
	std::cin >> n >> m;

	int points[2][2];
	int idx = 0;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			int x;
			std::cin >> x;
			if (x == 0) continue;
			
			points[idx][0] = i;
			points[idx][1] = j;
			idx++;
		}
	}

	int dist = std::abs(points[0][0] - points[1][0]) + std::abs(points[0][1] - points[1][1]);
	std::cout << dist;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}