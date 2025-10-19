#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	int n;

	int min = 5000, max = 1;
	std::cin >> n;
	while (n--) {
		int t, b;
		std::cin >> t >> b;
		min = std::min(min, b);
		max = std::max(max, t);
	}

	std::cout << max * min % 7 + 1;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}