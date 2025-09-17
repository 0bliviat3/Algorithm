#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>

void solve() {

	int n;
	std::cin >> n;

	int m = 1;
	for (int i = 0; i < 31; i++) {
		if (n == m) {
			std::cout << 1;
			return;
		}
		m <<= 1;
	}
	std::cout << 0;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}