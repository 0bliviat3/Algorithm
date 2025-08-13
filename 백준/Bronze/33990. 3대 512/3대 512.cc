#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>

void solve() {

	int n;
	std::cin >> n;

	int min = 123456789;
	while (n--) {
		int a, b, c;
		std::cin >> a >> b >> c;
		int sum = a + b + c;
		if (sum >= 512) {
			min = std::min(min, sum);
		}
	}
	if (min == 123456789) {
		std::cout << -1;
	} else {
		std::cout << min;
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}