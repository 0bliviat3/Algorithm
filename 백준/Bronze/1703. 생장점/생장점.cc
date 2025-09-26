#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	int n, a, b;
	while (true) {
		std::cin >> n;
		if (!n) {
			break;
		}
		int sum = 1;
		while (n--) {
			std::cin >> a >> b;
			sum *= a;
			sum -= b;
		}
		std::cout << sum << "\n";
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}