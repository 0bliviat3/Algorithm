#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	std::string line;
	while (true) {
		std::getline(std::cin, line);
		if (line == "#") break;

		int sum = 0;
		int length = line.length();
		for (int i = 0; i < length; i++) {
			char c = line[i];
			if (c >= 'A' && c <= 'Z') {
				sum += (c - 'A' + 1) * (i + 1);
			}
		}

		std::cout << sum << "\n";

	}

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}