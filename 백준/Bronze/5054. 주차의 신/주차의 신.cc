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
	while (n--) {
		int now;
		std::cin >> now;
		int max = 0, min = 100;
		for (int i = 0; i < now; i++) {
			int tmp;
			std::cin >> tmp;
			if (tmp > max) max = tmp;
			if (tmp < min) min = tmp;
		}
		int p = (max - min) * 2;
		
		std::cout << p << "\n";
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}