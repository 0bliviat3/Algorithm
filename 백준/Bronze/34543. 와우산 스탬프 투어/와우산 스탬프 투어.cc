#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	int n, w;
	std::cin >> n >> w;

	int sum = n * 10;
	if (n == 5) {
		sum += 70;
	} else if (n >= 3) {
		sum += 20;
	}
	if (w > 1000) {
		sum -= 15;
	}
	if (sum < 0) {
		sum = 0;
	}
	std::cout << sum;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}