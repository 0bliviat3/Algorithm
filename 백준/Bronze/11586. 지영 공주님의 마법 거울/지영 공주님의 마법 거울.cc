#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>

void solve() {
	int n;
	std::vector<std::string> grid;
	std::cin >> n;
	std::cin.ignore();
	while (n--) {
		std::string line;
		std::cin >> line;
		grid.push_back(line);
	}

	int angle;
	std::cin >> angle;
	if (angle == 3) {
		std::reverse(grid.begin(), grid.end());
	}

	for (std::string line : grid) {
		if (angle == 2) {
			std::reverse(line.begin(), line.end());
		}
		std::cout << line << '\n';
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}