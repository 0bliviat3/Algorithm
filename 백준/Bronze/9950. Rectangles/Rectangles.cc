#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	int a, b, c;
	while (true) {
		std::cin >> a >> b >> c;
		if (!(a + b + c)) {
			break;
		}
		if (c == 0) {
			std::cout << a << " " << b << " " << a * b << "\n";
		} else {
			a = (a) ? a : c / (a + b);
			b = (b) ? b : c / (a + b);
			std::cout << a << " " << b << " " << c << "\n";
		}
	}
	

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}