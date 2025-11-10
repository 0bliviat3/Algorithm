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

	int cnt = 0;
	while (n--) {
		int a, b, c, d;
		std::cin >> a >> b >> c >> d;
		if (a >= 1000 || b >= 1600 || c >= 1500 || (d > 0 && d <= 30)) {
			cnt++;
		}
	}

	std::cout << cnt;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}