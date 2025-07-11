#include <iostream>
#include <vector>
#include <sstream>
#include <string>

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
	std::string ans;
	std::cin >> n;
	std::cin.ignore();
	while (n--) {
		std::string line;
		std::getline(std::cin, line);
		std::vector<int> numbers = split_to_int(line, ' ');
		ans.append(std::to_string(numbers[1] - numbers[0] + 2))
			.append("\n");
	}

	std::cout << ans;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}