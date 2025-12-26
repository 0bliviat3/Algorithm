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

	std::cin.ignore();

	std::string line;
	while (n--) {
		int sum = 0;
		std::getline(std::cin, line);
		for (char c : line) {
			if (c == ' ') continue;
			sum += c - 'A' + 1;
		}
		if (sum == 100) {
			std::cout << "PERFECT LIFE\n";
		}
		else {
			std::cout << sum << "\n";
		}
	}

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}