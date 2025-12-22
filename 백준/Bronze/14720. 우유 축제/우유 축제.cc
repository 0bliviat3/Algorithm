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

	int start = 0;
	int cnt = 0;
	while (n--) {
		int now;
		std::cin >> now;
		if (now == start) {
			start = (start + 1) % 3;
			cnt++;
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