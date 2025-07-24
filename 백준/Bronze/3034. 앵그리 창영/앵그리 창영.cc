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

	std::string line;
	std::getline(std::cin, line);
	std::vector<int> arr = split_to_int(line, ' ');

	int length = arr[1] * arr[1] + arr[2] * arr[2];

	while (arr[0]--) {
		int n;
		std::cin >> n;
		if (length >= n * n) {
			std::cout << "DA\n";
		} else {
			std::cout << "NE\n";
		}
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}