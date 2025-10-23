#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	int a, d, k;
	std::cin >> a >> d >> k;
	k -= a;
	if (k % d != 0) {
		std::cout << "X";
		return;
	} else if (k / d + 1 < 1) {
		std::cout << "X";
		return;
	}
	std::cout << k / d + 1;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}