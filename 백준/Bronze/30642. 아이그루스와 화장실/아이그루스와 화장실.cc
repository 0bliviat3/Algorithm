#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	int n, k;
	std::cin >> n;
	std::cin.ignore();
	std::string s;
	std::getline(std::cin, s);
	std::cin >> k;

	if (s == "annyong") {
		if (k % 2 == 1) {
			std::cout << k;
		} else if (k < n) {
			std::cout << k + 1;
		} else {
			std::cout << k - 1;
		}
	} else {
		if (k % 2 == 0) {
			std::cout << k;
		} else if (k < n) {
			std::cout << k + 1;
		} else {
			std::cout << k - 1;
		}
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}