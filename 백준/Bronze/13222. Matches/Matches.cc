#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	int a, b, c;
	std::cin >> a >> b >> c;

	double d = std::sqrt(b * b + c * c);
	while (a--) {
		int n;
		std::cin >> n;
		if (n <= d) {
			std::cout << "YES\n";
		} else {
			std::cout << "NO\n";
		}
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}