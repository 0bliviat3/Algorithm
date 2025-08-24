#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>

void solve() {
	int n;
	std::cin >> n;

	int max = 0;

	while (n) {
		int lemon = 0;
		std::cin >> lemon;
		max = std::max(max, lemon - n);

		n--;
	}

	std::cout << max;
	

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}