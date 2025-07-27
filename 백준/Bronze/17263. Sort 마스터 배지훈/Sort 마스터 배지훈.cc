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
	std::string line;
	std::getline(std::cin, line);
	std::vector<int> arr = split_to_int(line, ' ');

	int max = 0;

	while (n--) {
		if (max < arr[n]) {
			max = arr[n];
		}
	}

	std::cout << max;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}