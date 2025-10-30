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

	int a = 0, b = 0;
	while (n--) {
		char c;
		std::cin >> c;
		if (c == 'A') {
			a++;
		} else {
			b++;
		}
	}
	if (a > b) {
		std::cout << "A\n";
	} else if (a < b) {
		std::cout << "B\n";
	} else {
		std::cout << "Tie\n";
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}