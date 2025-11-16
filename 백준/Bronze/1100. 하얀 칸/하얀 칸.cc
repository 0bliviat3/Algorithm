#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	int cnt = 0;
	for (int i = 0; i < 8; i++) {
		for (int j = 0; j < 8; j++) {
			char c; std::cin >> c;
			if (i % 2 == 0 && j % 2 == 0 && c == 'F') {
				cnt++;
			}
			else if (i % 2 == 1 && j % 2 == 1 && c == 'F') {
				cnt++;
			}
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