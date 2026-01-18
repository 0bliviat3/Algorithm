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

	int n;
	std::cin >> n;

	std::cin.ignore();

	while (n--) {
		std::string line;
		std::getline(std::cin, line);
		std::vector<std::string> words = split(line, ' ');
		for (size_t i = 0; i < words.size(); ++i) {
			std::reverse(words[i].begin(), words[i].end());
			std::cout << words[i] << " ";
		}
		std::cout << "\n";
	}

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}