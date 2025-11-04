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
	int y = 0, m = 0;
	while (n--) {
		int now;
		std::cin >> now;
		y += ((now / 30 + 1) * 10);
		m += ((now / 60 + 1) * 15);
	}
	if (y < m) {
		std::cout << "Y " << y << "\n";
	}
	else if (y > m) {
		std::cout << "M " << m << "\n";
	}
	else {
		std::cout << "Y M " << y << "\n";
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}