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
	for (int i = 1; i <= std::sqrt(n); i++) {
		if (n % i == 0) {
			sum += i;
			if (i != n / i) {
				sum += (n / i);
			}
		}
	}
	std::cout << sum * 5 - 24;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}