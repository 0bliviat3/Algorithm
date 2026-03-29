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

	int a, b;
	std::cin >> a >> b;

	int min = std::min(a, b);

	for (int i = 1; i <= min; i++) {
		if (a % i == 0 && b % i == 0) {
			std::cout << i << " " << (a / i) << " " << (b / i) << "\n";
		}
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}