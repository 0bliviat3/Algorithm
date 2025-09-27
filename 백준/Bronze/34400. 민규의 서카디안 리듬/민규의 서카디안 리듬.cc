#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	int t;
	std::cin >> t;
	while (t--) {
		
		int n;
		std::cin >> n;
		n %= 25;
		if (n < 17) {
			std::cout << "ONLINE" "\n";
		} else {
			std::cout << "OFFLINE" "\n";
		}
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}