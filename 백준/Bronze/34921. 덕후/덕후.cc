#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	int n, m;
	std::cin >> n >> m;

	int p = 10 + 2 * (25 - n + m);

	if (p < 0) {
		p = 0;
	}

	std::cout << p;

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}