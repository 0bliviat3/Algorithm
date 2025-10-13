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
	int standard = (n % 2 == 0) ? n / 2 : n / 2 + 1;
	while (n--) {
		char c;
		std::cin >> c;
		if (c == 'O') {
			cnt++;
		}
	}
	if (cnt >= standard) {
		std::cout << "Yes";
	} else {
		std::cout << "No";
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}