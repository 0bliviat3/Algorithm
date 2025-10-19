#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	std::string line;
	std::getline(std::cin, line);
	int alpahabet[26] = { 0, };
	for (char c : line) {
		alpahabet[c - 'a']++;
	}
	bool isOdd = false, isEven = false;
	for (int i = 0; i < 26; i++) {
		if (alpahabet[i] > 0) {
			if (alpahabet[i] % 2 == 0) {
				isEven = true;
			} else {
				isOdd = true;
			}
		}
	}
	if (isOdd && isEven) {
		std::cout << "0/1";
	} else if (isOdd) {
		std::cout << "1";
	} else {
		std::cout << "0";
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}