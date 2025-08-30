#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>

void solve() {
	int n;
	std::cin >> n;
	while (n--) {
		int i, m;
		std::cin >> i >> m;
		std::cout << i << " " << m + m * (m + 1) / 2 << "\n";
	}

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}