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
	int n = numbers[0];
	int time = numbers[1];

	std::getline(std::cin, input);
	numbers = split_to_int(input, ' ');

	int sum = 0;
	for (int i = 0; i < n; ++i) {
		sum += numbers[i];
		if (sum > time) {
			std::cout << i << std::endl;
			return;
		}
	}

	std::cout << n << std::endl;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}