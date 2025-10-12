#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	long long x1, y1, x2, y2, r1, r2;
	std::cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;
	long long dist = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
	long long rsum = (r1 + r2) * (r1 + r2);

	if (dist < rsum) std::cout << "YES";
	else std::cout << "NO";
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}