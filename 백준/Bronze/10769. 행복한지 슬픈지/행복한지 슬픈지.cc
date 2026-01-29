#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>


void solve() {

	std::string line;
	std::getline(std::cin, line);

	int happy = 0;
	int sad = 0;

	char prev = '\0';
	for (char c : line) {
		if (c == ':') {
			prev = c;
			continue;
		} else if (prev == ':' && c == '-') {
			prev = c;
			continue;
		} else if (prev == '-' && c == ')') {
			happy++;
			prev = '\0';
		} else if (prev == '-' && c == '(') {
			sad++;
			prev = '\0';
		} else {
			prev = '\0';
		}
	}

	if (happy == 0 && sad == 0) {
		std::cout << "none\n";
	} else if (happy > sad) {
		std::cout << "happy\n";
	} else if (sad > happy) {
		std::cout << "sad\n";
	} else {
		std::cout << "unsure\n";
	}

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}