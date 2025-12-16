#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	int n;
	std::cin >> n;
	
	std::string line, line2;
	std::cin.ignore();

	std::getline(std::cin, line);
	std::getline(std::cin, line2);

	std::string remove = "";
	for (int i = 0; i < line.size(); i++) {
		if (line[i] == '0') {
			remove += '1';
		}
		else {
			remove += '0';
		}
		
	}

	n %= 2;
	if ((!n && line == line2) || (n && line2 == remove)) {
		std::cout << "Deletion succeeded";
	}
	else {
		std::cout << "Deletion failed";
	}

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}