#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>

void solve() {

	int x, y;
	std::cin >> x;
	std::cin.ignore();
	char input;
	while (true) {
		std::cin >> input;
		if (input == '=') break;
		std::cin >> y;
		switch (input) {
			case '+':
				x += y;
				break;
			case '-':
				x -= y;
				break;
			case '*':
				x *= y;
				break;
			case '/':
				x /= y;
				break;
			default:
				return;
		}
	}

	std::cout << x << std::flush;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}