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

	long long pre = LLONG_MIN;
	while (n--) {
		long long now;
		std::cin >> now;

		if (now <= pre) {
			std::cout << 0;
			return;
		}
		pre = now;
	}

	std::cout << 1;

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}