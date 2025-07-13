#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>

void solve() {

	int n = 4;
	int sum = 0;
	while (n--) {
		int m;
		std::cin >> m;
		sum += m;
	}

	if (sum <= 1500) {
		std::cout << "Yes";
		return;
	}

	std::cout << "No";
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}