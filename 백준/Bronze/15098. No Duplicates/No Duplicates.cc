#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>
#include <unordered_set>


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

	std::string line;
	std::getline(std::cin, line);
	auto tokens = split(line, ' ');

	std::unordered_set<std::string> unique_tokens;
	for (const auto& token : tokens) {
		if (unique_tokens.find(token) != unique_tokens.end()) {
			std::cout << "no\n";
			return;
		}
		unique_tokens.insert(token);
	}
	std::cout << "yes\n";
	
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}