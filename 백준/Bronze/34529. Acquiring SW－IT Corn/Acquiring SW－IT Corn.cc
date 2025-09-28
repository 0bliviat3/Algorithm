#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	int x, y, z;
	int u, v, w;
	std::cin >> x >> y >> z >> u >> v >> w;

	std::cout << u / 100 * x + v / 50 * y + w / 20 * z;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}