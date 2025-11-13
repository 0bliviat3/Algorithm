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
		double a, b, c;
		std::cin >> a >> b >> c;
		
		if (a + b == c || a - b == c || b - a == c || a * b == c || (a / b == c) || (b / a == c)) {
			std::cout << "Possible\n";
		} else {
			std::cout << "Impossible\n";
		}
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}