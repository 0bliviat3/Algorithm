#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	std::string input;
	std::getline(std::cin, input);
	int sum = 5;
	char prev = input[0];
	for (char c : input) {
		if (c == prev) {
			sum += 5;
		} else {
			sum += 10;
		}
		prev = c;
	}
	std::cout << sum;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}