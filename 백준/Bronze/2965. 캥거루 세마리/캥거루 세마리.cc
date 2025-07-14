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
	int a = numbers[1] - numbers[0] - 1;
	int b = numbers[2] - numbers[1] - 1;
	int max = std::max(a, b);

	std::cout << max << std::flush;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}