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

	int sum = 0;
	int max = 0;
	while (n--) {
		int now;
		std::cin >> now;
		sum += now;
		if (now > max) {
			max = now;
		}
	}

	std::cout << sum - max;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}