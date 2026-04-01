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

	int n;
	std::cin >> n;
	double sum = 0.0;

	while (n--) {
		double now;
		std::cin >> now;
		sum += now * now * now;
	}

	double ans = std::cbrt(sum);

	std::cout << std::fixed << std::setprecision(6) << ans << "\n";
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}