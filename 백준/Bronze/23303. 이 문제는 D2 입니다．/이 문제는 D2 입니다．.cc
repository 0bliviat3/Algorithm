#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>

void solve() {

	std::string input;
	std::getline(std::cin, input);

	if (input.find("d2") != std::string::npos || input.find("D2") != std::string::npos) {
		std::cout << "D2";
		return;
	}
	std::cout << "unrated";
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}