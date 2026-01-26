#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>


std::vector <std::string> split(const std::string& str, std::string& delimiters) {
	std::vector<std::string> tokens;
	std::string token;
	
	std::istringstream tokenStream(str);
	char ch;

	while (tokenStream.get(ch)) {
		if (delimiters.find(ch) != std::string::npos) {
			if (!token.empty()) {
				tokens.push_back(token);
				token.clear();
			}
		} else {
			token += ch;
		}
	}

	if (!token.empty()) {
		tokens.push_back(token);
	}

	return tokens;
}

void solve() {

	int n;
	std::cin >> n;

	std::cin.ignore();
	std::string line;
	std::getline(std::cin, line);

	std::string delimiters = ".|:#";
	std::vector<std::string> strs = split(line, delimiters);
	
	int sum = 0;
	for (std::string& s : strs) {
		sum += std::stoi(s);
	}

	std::cout << sum;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}