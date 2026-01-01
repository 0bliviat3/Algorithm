#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>


void solve() {

	int a, b, c, d;
	std::cin >> a >> b >> c >> d;

	a += b;
	if (a <= d && c <= d) {
		std::cout << "~.~";
	} else if (a <= d) {
		std::cout << "Shuttle";
	}
	else if (c <= d) {
		std::cout << "Walk";
	} else {
		std::cout << "T.T";
	}

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}