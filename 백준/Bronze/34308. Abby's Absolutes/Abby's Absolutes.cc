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

	int n, k;
	std::cin >> n >> k;

	while (k--) {
		int a;
		std::cin >> a;

		int lower = std::abs(a - 1);
		int upper = std::abs(a - n);

		if (lower > upper) {
			std::cout << n << " ";
		}
		else {
			std::cout << 1 << " ";
		}
	}

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}