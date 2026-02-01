#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>



void solve() {

	std::string line, line2;
	std::getline(std::cin, line);
	std::getline(std::cin, line2);

	if (line == "null") {
		std::cout << "NullPointerException\nNullPointerException";
			return;
	}

	if (line2 == "null") {
		std::cout << "false\nfalse";
		return;
	}

	if (line == line2) {
		std::cout << "true\n";
	} else {
		std::cout << "false\n";
	}
	
	std::string ignore_line = "", ignore_line2 = "";

	for (char c : line) {
		if (c >= 'A' && c <= 'Z') {
			ignore_line += c + 32;
		} else {
			ignore_line += c;
		}
	}

	for (char c : line2) {
		if (c >= 'A' && c <= 'Z') {
			ignore_line2 += c + 32;
		}
		else {
			ignore_line2 += c;
		}
	}

	if (ignore_line == ignore_line2) {
		std::cout << "true\n";
	} else {
		std::cout << "false\n";
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}