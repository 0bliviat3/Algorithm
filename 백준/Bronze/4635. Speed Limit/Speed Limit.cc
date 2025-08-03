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

	while (true) {
		int n;
		std::cin >> n;
		std::cin.ignore();

		if (n == -1) {
			break;
		}

		std::string line;
		std::vector<int> arr;
		int dist = 0;
		int sum = 0;

		while (n--) {
			std::getline(std::cin, line);
			arr = split_to_int(line, ' ');
			sum += (arr[0] * (arr[1] - dist));
			dist = arr[1];
		}
		std::cout << sum << " miles" << "\n";
	}

	
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}