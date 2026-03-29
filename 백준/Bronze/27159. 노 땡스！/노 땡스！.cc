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

	int n;
	std::cin >> n;

	int sum = 0;
	int prev = 0;
	for (int i = 0; i < n; i++) {
		int now;
		std::cin >> now;
		if (prev + 1 == now) {
			prev = now;
			continue;
		}
		prev = now;
		sum += now;
	}

	std::cout << sum;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}