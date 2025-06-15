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
	int test_cases;
	std::cin >> test_cases;
	std::cin.ignore();
	std::string ans;

	while (test_cases--) {
		std::string line;
		std::getline(std::cin, line);
		std::getline(std::cin, line);
		std::vector<int> numbers = split_to_int(line, ' ');
		int sum = 0;
		for (int num : numbers) {
			sum += num;
		}
		ans.append(std::to_string(sum))
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