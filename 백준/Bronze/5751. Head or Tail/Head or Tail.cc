#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	while (true) {
		int n;
		std::cin >> n;
		if (n == 0) break;
		int a = 0, b = 0;
		while (n--) {
			int now;
			std::cin >> now;
			if (now) {
				b++;
			} else {
				a++;
			}
		}
		std::cout << "Mary won " << a << " times and John won " << b << " times\n";
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}