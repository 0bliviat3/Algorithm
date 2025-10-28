#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	double arr[] = { 350.34, 230.90, 190.55, 125.30, 180.90 };
	int n;
	std::cin >> n;
	std::cout << std::fixed;
	std::cout.precision(2);
	while (n--) {
		double sum = 0.0;
		for (int i = 0; i < 5; ++i) {
			int x;
			std::cin >> x;
			sum += arr[i] * x;
		}
		std::cout << "$" << sum << '\n';
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}