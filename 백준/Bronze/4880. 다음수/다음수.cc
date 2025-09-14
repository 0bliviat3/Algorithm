#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>

void solve() {

	int a, b, c;
	while (true) {
		std::cin >> a >> b >> c;
		if (a == 0 && b == 0 && c == 0) break;
		if (b * 2 == a + c) {
			std::cout << "AP " << c + (c - b) << "\n";
		} else {
			std::cout << "GP " << c * (c / b) << "\n";
		}
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}