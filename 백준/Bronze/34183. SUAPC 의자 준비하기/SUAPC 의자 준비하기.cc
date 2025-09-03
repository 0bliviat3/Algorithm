#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>

void solve() {
	int a, b, c, d;
	std::cin >> a >> b >> c >> d;
	a *= 3;
	a -= b;

	if (a > 0) {
		std::cout << a * c + d;
		return;
	}
	std::cout << 0;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}