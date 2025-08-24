#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>


int get_dist(int x1, int y1, int x2, int y2) {
	return std::abs(x1 - x2) + std::abs(y1 - y2);
}

void solve() {
	int n;
	std::cin >> n;
	int sum = 0;
	int prev_x = 0, prev_y = 0;
	int first_x = 0, first_y = 0;
	for (int i = 0; i < n; ++i) {
		int x, y;
		std::cin >> x >> y;
		if (i == 0) {
			first_x = x;
			first_y = y;
		} else {
			sum += get_dist(prev_x, prev_y, x, y);
		}
		prev_x = x;
		prev_y = y;
	}

	sum += get_dist(prev_x, prev_y, first_x, first_y);
	std::cout << sum;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}