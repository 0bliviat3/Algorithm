#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	while (true) {
		std::string input;
		std::getline(std::cin, input);

		if (input == "end") {
			break;
		}
		else if (input == "animal") {
			std::cout << "Panthera tigris\n";
		}
		else if (input == "flower") {
			std::cout << "Forsythia koreana\n";
		}
		else if (input == "tree") {
			std::cout << "Pinus densiflora\n";
		}
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}