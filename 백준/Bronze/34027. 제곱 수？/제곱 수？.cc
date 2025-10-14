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

	while (n--) {
		int a;
		std::cin >> a;
		int b = std::sqrt(a);
		if (b * b == a) {
			std::cout << "1\n";
		} else {
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