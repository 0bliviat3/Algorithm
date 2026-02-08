#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>

std::vector <std::string> split(const std::string& str, char delimiter) {
	std::vector<std::string> tokens;
	std::string token;
	std::istringstream tokenStream(str);
	while (std::getline(tokenStream, token, delimiter)) {
		tokens.push_back(token);
	}
	return tokens;
}

void solve() {

	std::string commend;
	std::string line;
	

	while (true) {
		std::getline(std::cin, line);
		
		if (line.empty()) {
			break;
		}

		commend += line;
	}

	int sum = 0;

	std::vector<std::string> numbers = split(commend, ',');
	for (const std::string& numStr : numbers) {
		sum += std::stoi(numStr);
	}

	std::cout << sum;

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}