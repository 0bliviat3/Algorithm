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

	std::string start;
	std::getline(std::cin, start);

	auto tokens = split(start, ' ');

	int n = std::stoi(tokens[0]);
	std::string name = tokens[1];

	int idx = 0;
	std::string ans;

	std::vector<std::string> names(n);
	std::vector<std::string> answers(n);
	for (int i = 0; i < n; i++) {
		std::string line;
		std::getline(std::cin, line);
		auto tokens = split(line, ' ');
		names[i] = tokens[0];
		answers[i] = tokens[1];
		if (tokens[0] == name) {
			idx = i;
			ans = tokens[1];
		}
	}

	int cnt = 0;
	for (int i = 0; i < idx; i++) {
		if (answers[i] == ans) {
			cnt++;
		}
	}

	std::cout << cnt;

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}