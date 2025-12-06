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

	std::string str;
	std::getline(std::cin, str);

	int sum = 0;
	std::vector<std::string> numbers = split(str, ',');
	for (const std::string& numStr : numbers) {
		sum += std::stoi(numStr);
	}
	std::cout << sum << "\n";
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}