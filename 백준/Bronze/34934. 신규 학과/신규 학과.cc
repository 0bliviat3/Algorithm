#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>


std::vector<std::string> split(const std::string& str, char delimiter) {
	std::vector<std::string> tokens;
	std::string token;
	std::istringstream tokenStream(str);
	while (std::getline(tokenStream, token, delimiter)) {
		tokens.push_back(token);
	}
	return tokens;
}

void solve() {

	int n;
	std::cin >> n;

	std::cin.ignore();
	int max = 2026;
	std::string line;

	while (n--) {
		std::getline(std::cin, line);
		std::vector<std::string> parts = split(line, ' ');
		int year = std::stoi(parts[1]);
		if (year == max) {
			std::cout << parts[0] << "\n";
			return;
		}
	}

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}