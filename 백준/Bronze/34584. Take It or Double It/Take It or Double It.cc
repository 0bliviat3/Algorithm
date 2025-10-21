#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	long long n, m;
	std::cin >> n >> m;
	if (n * 2 > m) {
		std::cout << "take it";
	} else {
		std::cout << "double it";
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}