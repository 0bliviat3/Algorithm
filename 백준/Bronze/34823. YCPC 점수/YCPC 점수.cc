#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	int y, c, p;
	std::cin >> y >> c >> p;

	c /= 2;

	int min = std::min({ y, c, p });

	std::cout << min;

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}