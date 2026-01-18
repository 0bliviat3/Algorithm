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

	std::string line;
	std::getline(std::cin, line);
	std::vector<std::string> words = split(line, ' ');

	for (std::string& word : words) {
		for (char& ch : word) {
			if (ch >= 'A' && ch <= 'Z') {
				ch = (ch - 'A' + 13) % 26 + 'A';
			} else if (ch >= 'a' && ch <= 'z') {
				ch = (ch - 'a' + 13) % 26 + 'a';
			}
		}
	}

	for (size_t i = 0; i < words.size(); ++i) {
		std::cout << words[i] << ' ';
	}

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}