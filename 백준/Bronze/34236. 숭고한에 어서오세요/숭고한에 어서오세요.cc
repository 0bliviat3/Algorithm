#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>

void solve() {

	int n;
	std::cin >> n;
	int now, gap, pre = 0;
	while (n--) {
		std::cin >> now;
		if (pre) {
			gap = now - pre;
		}
		pre = now;
	}
	std::cout << pre + gap;

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}