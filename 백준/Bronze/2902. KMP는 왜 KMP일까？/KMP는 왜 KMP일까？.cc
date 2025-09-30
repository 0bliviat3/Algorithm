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

	std::string input;
	std::getline(std::cin, input);
	std::vector<std::string> arr = split(input, '-');
	for (std::string str : arr) {
		std::cout << str[0];
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}