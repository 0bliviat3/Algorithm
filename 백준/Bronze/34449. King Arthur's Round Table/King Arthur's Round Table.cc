#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>
#include <unordered_map>

void solve() {

	double d, w, n;
	std::cin >> d >> w >> n;

	double pie = 3.14159;

	if (d * pie >= w * n) std::cout << "YES\n";
	else std::cout << "NO\n";
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}