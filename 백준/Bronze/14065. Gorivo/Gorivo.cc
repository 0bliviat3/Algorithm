#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>


void solve() {

	double x;
	std::cin >> x;

	double result = 100.0 / ((1.609344 / 3.785411784) * x);

	std::cout << std::fixed << std::setprecision(6) << result << "\n";
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}