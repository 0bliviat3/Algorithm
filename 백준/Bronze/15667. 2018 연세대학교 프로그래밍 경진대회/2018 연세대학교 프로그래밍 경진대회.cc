#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>

void solve() {
	int a;
	std::cin >> a;
	
	int sum;
	for (int i = 1; i <= 100; i++) {
		sum = 0;
		sum = 1 + i + i * i;
		if (sum == a) {
			std::cout << i;
			return;
		}
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}