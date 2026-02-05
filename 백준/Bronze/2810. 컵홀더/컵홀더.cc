#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>

void solve() {

	int n;
	std::cin >> n;

	int cups = 1;
	bool isL = 0;
	for (int i = 0; i < n; i++) {
		char c;
		std::cin >> c;
		if (c == 'S') {
			cups++;
		}
		else if (c == 'L') {
			if (isL) {
				isL = 0;
				cups++;
			}
			else {
				isL = 1;
			}
		}
	}

	std::cout << std::min(cups, n);

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}