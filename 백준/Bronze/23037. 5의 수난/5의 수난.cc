#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	int sum = 0;
	int n;
	std::cin >> n;
	for (int i = 0; i < 5; i++) {
		int m = n % 10;
		sum += std::pow(m, 5);
		n /= 10;
	}

	std::cout << sum << "\n";

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}