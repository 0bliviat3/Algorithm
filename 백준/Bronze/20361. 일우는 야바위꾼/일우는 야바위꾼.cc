#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	int n, x, k;
	std::cin >> n >> x >> k;
	while (k--) {
		int a, b;
		std::cin >> a >> b;
		if (a == x) {
			x = b;
		} else if (b == x) {
			x = a;
		}
	}
	std::cout << x;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}