#include <iostream>
#include <vector>
#include <sstream>
#include <string>

std::vector<std::string> split_to_str(std::string str, char delimiter) {
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
	std::vector<std::string> numbers = split_to_str(input, ' ');

	long long ab = std::stoll(numbers[0] + numbers[1]);
	long long cd = std::stoll(numbers[2] + numbers[3]);

	std::cout << ab + cd << '\n';
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}