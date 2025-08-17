#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>

void solve() {

	int n;
	std::cin >> n;

	while (n--) {
		int a, b;
		std::cin >> a >> b;
		std::cout << "You get " << a / b << " piece(s) and your dad gets " << a % b << " piece(s).\n";
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}