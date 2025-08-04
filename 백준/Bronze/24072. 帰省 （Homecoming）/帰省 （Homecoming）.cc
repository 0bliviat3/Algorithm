#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>

std::vector<int> split_to_int(std::string str, char delimiter) {
	std::istringstream ss(str);
	std::string buffer;

	std::vector<int> result;

	while (std::getline(ss, buffer, delimiter)) {
		result.push_back(std::stoi(buffer));
	}

	return result;
}

void solve() {

	std::string input;
	std::getline(std::cin, input);
	std::vector<int> numbers = split_to_int(input, ' ');

	if (numbers[0] > numbers[2]) {
		std::cout << 0;
	} else if (numbers[1] > numbers[2]) {
		std::cout << 1;
	} else {
		std::cout << 0;
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}