#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	int n;
	std::cin >> n;

	n /= 100;

	if (n >= 10000) {
		std::cout << n * 20 << " " << n * 80;
	} else if (n >= 5000 && n < 10000) {
		std::cout << n * 15 << " " << n * 85;
	} else if (n >= 1000 && n < 5000) {
		std::cout << n * 10 << " " << n * 90;
	} else {
		std::cout << n * 5 << " " << n * 95;
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}