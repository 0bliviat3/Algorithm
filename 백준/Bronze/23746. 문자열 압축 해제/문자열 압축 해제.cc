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

	std::string arr[26] = { "" };
	while (n--) {
		std::string line;
		std::getline(std::cin, line);
		std::vector<std::string> words = split(line, ' ');
		arr[words[1][0] - 'A'] = words[0];
	}

	std::string command;
	std::getline(std::cin, command);

	std::string commandToStr = "";

	for (char c : command) {
		commandToStr += arr[c - 'A'];
	}

	int begin, end;
	std::cin >> begin >> end;

	std::cout << commandToStr.substr(begin - 1, end - begin + 1) << "\n";
	
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}