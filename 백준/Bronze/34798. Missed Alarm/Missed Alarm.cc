#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>


std::vector<int> split(const std::string& str, char delimiter) {
	std::vector<int> tokens;
	std::string token;
	std::istringstream tokenStream(str);
	while (std::getline(tokenStream, token, delimiter)) {
		tokens.push_back(std::stoi(token));
	}
	return tokens;
}

void solve() {

	std::string line, line2;

	std::getline(std::cin, line);
	std::getline(std::cin, line2);

	std::vector<int> vec1 = split(line, ':');
	std::vector<int> vec2 = split(line2, ':');


	int alarm = vec1[0] * 60 + vec1[1];
	int wake = vec2[0] * 60 + vec2[1];

	if (wake < alarm) {
		std::cout << "NO";
	} else {
		std::cout << "YES";
	}

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}