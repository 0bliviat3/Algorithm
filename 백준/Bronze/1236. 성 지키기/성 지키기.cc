#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>

void solve() {

	int n, m;

	std::cin >> n >> m;

	std::vector<bool> row(n, false);
	std::vector<bool> col(m, false);

	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			char c;
			std::cin >> c;
			if (c == 'X') {
				row[i] = true;
				col[j] = true;
			}
		}
	}
	int rowCount = 0;
	int colCount = 0;
	for (int i = 0; i < n; ++i) {
		if (!row[i]) {
			++rowCount;
		}
	}
	for (int j = 0; j < m; ++j) {
		if (!col[j]) {
			++colCount;
		}
	}
	std::cout << std::max(rowCount, colCount);

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}