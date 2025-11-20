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

	int max = 0;
	int min = 1000;

	while (n--) {
		int now;
		std::cin >> now;
		if (now > max) max = now;
		if (now < min) min = now;
	}

	std::cout << max - min;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}