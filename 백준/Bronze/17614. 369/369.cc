#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>

void solve() {

	int n;
	std::cin >> n;

	int count = 0;
	for (int i = 1; i <= n; ++i) {
		int now = i;
		while (now) {
			int digit = now % 10;
			if (digit != 0 && !(digit % 3)) {
				count++;
			}
			now /= 10;
		}
	}
	std::cout << count;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}