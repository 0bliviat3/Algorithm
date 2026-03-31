#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>
#include <unordered_map>

void solve() {

	double a, b, c;
	std::cin >> a >> b >> c;

	double ans = a * 229 * 324 * 2 / 1000000 + b * 297 * 420 * 2 / 1000000 + c * 210 * 297 / 1000000;

	std::cout << std::fixed << std::setprecision(6) << ans << "\n";
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}