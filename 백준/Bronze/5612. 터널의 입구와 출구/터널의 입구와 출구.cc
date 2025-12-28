#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	int n, m;
	std::cin >> n >> m;

	int max = m;
	bool flag = false;
	while (n--) {
		int a, b;
		std::cin >> a >> b;
		m += (a - b);
		if (m < 0) {
			flag = true;
		}
		if (m > max) {
			max = m;
		}
	}

	if (flag) {
		std::cout << 0;
	}
	else {
		std::cout << max;
	}

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}