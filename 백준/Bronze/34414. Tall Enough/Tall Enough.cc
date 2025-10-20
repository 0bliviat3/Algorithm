#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	int n;
	std::cin >> n;
	while (n--) {
		int inche;
		std::cin >> inche;
		if (inche < 48) {
			std::cout << "False";
			return;
		}
	}
	std::cout << "True";
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}