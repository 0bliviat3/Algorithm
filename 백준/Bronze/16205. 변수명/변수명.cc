#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>
#include <unordered_map>

void printCamelCase(std::vector<std::string> str) {
	for (int i = 0; i < str.size(); i++) {
		if (i == 0) {
			std::cout << str[i];
		}
		else {
			str[i][0] = std::toupper(str[i][0]);
			std::cout << str[i];
		}
	}
}

void printSnakeCase(std::vector<std::string> str) {
	for (int i = 0; i < str.size(); i++) {
		if (i == 0) {
			std::cout << str[i];
		}
		else {
			std::cout << "_" << str[i];
		}
	}
}

void printPascalCase(std::vector<std::string> str) {
	for (int i = 0; i < str.size(); i++) {
		str[i][0] = std::toupper(str[i][0]);
		std::cout << str[i];
	}
}

void solve() {

	int n;
	std::cin >> n;

	std::string s;

	std::cin >> s;
	int len = s.length();

	std::vector<std::string> originStr;

	int splitIdx = 0;
	if (n == 1) {
		for (int i = 0; i < len; i++) {
			if (s[i] >= 'A' && s[i] <= 'Z') {
				s[i] = std::tolower(s[i]);
				originStr.push_back(s.substr(splitIdx, i - splitIdx));
				splitIdx = i;
			}
		}
	}
	else if (n == 2) {
		for (int i = 0; i < len; i++) {
			if (s[i] == '_') {
				originStr.push_back(s.substr(splitIdx, i - splitIdx));
				splitIdx = i + 1;
			}
		}
	}
	else if (n == 3) {
		s[0] = std::tolower(s[0]);
		for (int i = 0; i < len; i++) {
			if (s[i] >= 'A' && s[i] <= 'Z') {
				s[i] = std::tolower(s[i]);
				originStr.push_back(s.substr(splitIdx, i - splitIdx));
				splitIdx = i;
			}
		}
	}

	originStr.push_back(s.substr(splitIdx, len - splitIdx + 1));

	printCamelCase(originStr);
	std::cout << "\n";
	printSnakeCase(originStr);
	std::cout << "\n";
	printPascalCase(originStr);

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}