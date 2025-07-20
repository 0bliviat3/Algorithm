#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	double n;
	std::cin >> n;
	
	double result = sqrt(3.0) / 4.0 * n * n;

	std::cout << std::fixed << std::setprecision(10) << result;
	
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}