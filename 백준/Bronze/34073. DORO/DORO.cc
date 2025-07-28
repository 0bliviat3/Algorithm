#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>

std::vector<std::string> split_to_int(std::string str, char delimiter) {
	std::istringstream ss(str);
	std::string buffer;

	std::vector<std::string> result;

	while (std::getline(ss, buffer, delimiter)) {
		result.push_back(buffer);
	}

	return result;
}

void solve() {

	int n;
	std::cin >> n;
	std::cin.ignore();
	std::string line;
	std::getline(std::cin, line);
	std::vector<std::string> arr = split_to_int(line, ' ');

	for (int i = 0; i < n; ++i) {
		std::cout << arr[i] << "DORO";
		if (i == n - 1) {
			continue;
		}
		std::cout << " ";
	}

	
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}