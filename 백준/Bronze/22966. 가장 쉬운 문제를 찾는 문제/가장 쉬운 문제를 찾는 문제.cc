#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

std::vector<std::string> split(std::string str, char delimiter) {
	std::istringstream ss(str);
	std::string buffer;

	std::vector<std::string> result;

	while (std::getline(ss, buffer, delimiter)) {
		result.push_back(buffer);
	}

	return result;
}

void solve() {

	int n;
	std::cin >> n;
	std::cin.ignore();

	std::string word;
	int min = 5;

	while (n--) {
		std::string str;
		std::getline(std::cin, str);
		std::vector<std::string> words = split(str, ' ');
		int rank = std::stoi(words[1]);
		if (rank < min) {
			min = rank;
			word = words[0];
		}
	}

	std::cout << word;
	
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}