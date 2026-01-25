#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>

void solve() {

	int n;
	std::cin >> n;

	std::vector<std::vector<char>> grid(n, std::vector<char>(n));
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			std::cin >> grid[i][j];
		}
	}

	for (int i = 0; i < n; i++) {
		std::string row = "";
		std::string col = "";
		for (int j = 0; j < n; j++) {
			row += grid[i][j];
			col += grid[j][i];
		}
		if (row != col) {
			std::cout << "NO";
			return;
		}
	}

	std::cout << "YES";

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}