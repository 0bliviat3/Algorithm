#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	std::string s = "CAMBRIDGE";
	bool check[26] = { false, };
	for (char c : s) {
		check[c - 'A'] = true;
	}
	std::string input;
	std::getline(std::cin, input);


	for (char c : input) {
		if (!check[c - 'A']) {
			std::cout << c;
		}
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}