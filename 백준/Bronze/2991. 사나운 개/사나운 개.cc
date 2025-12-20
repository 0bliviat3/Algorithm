#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	int a, b, c, d;
	std::cin >> a >> b >> c >> d;

	for (int i = 0; i < 3; i++) {
		int now;
		std::cin >> now;
		int moda = now % (a + b);
		int modb = now % (c + d);

		if (moda == 0) moda = a + b;
		if (modb == 0) modb = c + d;

		if (moda <= a && modb <= c) {
			std::cout << "2\n";
		}
		else if (moda <= a) {
			std::cout << "1\n";
		}
		else if (modb <= c) {
			std::cout << "1\n";
		}
		else {
			std::cout << "0\n";
		}
	}

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}