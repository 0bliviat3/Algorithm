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
	std::string ans;

	while (true) {
		std::getline(std::cin, line);
		if (line == "0 0 0 0") {
			break;
		}
		std::vector<int> arr = split_to_int(line, ' ');
		std::cout << arr[2] - arr[1] << " " 
			<< arr[3] - arr[0] << "\n";
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}