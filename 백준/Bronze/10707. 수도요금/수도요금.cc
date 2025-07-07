#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>

void solve() {

	int a, b, c, d, p;

	std::cin >> a >> b >> c >> d >> p;
	std::cin.ignore();

	int cost_a = a * p;
	int cost_b = 0;

	if (p <= c) {
		cost_b = b;
	} else {
		cost_b = b + (p - c) * d;
	}

	std::cout << std::min(cost_a, cost_b) << std::flush;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}