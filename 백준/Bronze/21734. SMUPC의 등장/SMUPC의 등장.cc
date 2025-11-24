#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	std::string str;
	std::getline(std::cin, str);

	for (char c : str) {
		int now = c - 0;
		int sum = 0;
		while (now > 0) {
			sum += now % 10;
			now /= 10;
		}

		while (sum--) {
			std::cout << c;
		}
		std::cout << "\n";
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}