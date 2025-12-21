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
		
		int odd = 0;
		int size = line.size();
		for (int i = 0; i < size - 1; ++i) {
			if (line[i] == '1') {
				odd++;
			}
		}
		char check = line[size - 1];
		if (check == 'e') {
			if (odd % 2 == 0) {
				std::cout << line.substr(0, size - 1) << '0' << '\n';
			} else {
				std::cout << line.substr(0, size - 1) << '1' << '\n';
			}
		}
		else if (check == 'o') {
			if (odd % 2 == 0) {
				std::cout << line.substr(0, size - 1) << '1' << '\n';
			}
			else {
				std::cout << line.substr(0, size - 1) << '0' << '\n';

			}
		}

	}

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}