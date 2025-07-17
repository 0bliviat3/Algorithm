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

	int n;
	std::cin >> n;
	std::cin.ignore();

	while (n--) {
		std::string input;
		std::getline(std::cin, input);
		std::vector<int> numbers = split_to_int(input, ' ');
		std::getline(std::cin, input);
		std::vector<int> numbers2 = split_to_int(input, ' ');
		int sum = 0;
		for (int i = 0; i < numbers[0]; i++) {
			sum += (numbers2[i] / numbers[1]);
		}
		std::cout << sum << '\n';
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}