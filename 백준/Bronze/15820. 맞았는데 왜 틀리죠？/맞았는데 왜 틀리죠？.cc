#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>

void solve() {

	int a, b;
	std::cin >> a >> b;
	while (a--) {
		int c, d;
		std::cin >> c >> d;
		if (c != d) {
			std::cout << "Wrong Answer";
			return;
		}
	}
	while (b--) {
		int c, d;
		std::cin >> c >> d;
		if (c != d) {
			std::cout << "Why Wrong!!!";
			return;
		}
	}
	std::cout << "Accepted";
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}