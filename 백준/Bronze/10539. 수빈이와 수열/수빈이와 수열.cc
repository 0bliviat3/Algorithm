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

	int pre = 0;
	for (int i = 1; i <= n; ++i) {
		int val;
		std::cin >> val;
		val *= i;
		if (i == 1) {
			std::cout << val << ' ';
			pre = val;
			continue;
		}
		std::cout << val - pre << ' ';
		pre = val;
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}