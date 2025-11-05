#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	std::string a, b;
	std::getline(std::cin, a);
	std::getline(std::cin, b);
	if (a == b) {
		std::cout << 0;
	} else {
		std::cout << 1550;
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}