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
	int cnt = 1;
	for (char c : input) {
		if (c == ',') {
			cnt++;
		}
	}

	std::cout << cnt;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}